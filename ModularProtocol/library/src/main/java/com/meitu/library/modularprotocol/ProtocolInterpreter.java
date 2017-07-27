package com.meitu.library.modularprotocol;

import android.util.Log;
import android.widget.Toast;
import android.content.Context;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxd on 16/3/24.
 */
public class ProtocolInterpreter {
    private static final String TAG = "ProtocolInterpreter";
    /**
     * 缓存通过反射取到的方法实现
     */
    private Map<Class<?>, InvocationHandler> mInvocationHandlerMap = new HashMap<>();
    /**
     * 缓存动态代理构建的对象（接口实现）
     */
    private Map<Class<?>, Object> mShadowBeanMap = new HashMap<>();
    private Context mContext;
    /**
     * 找不到类和方法的错误回调
     */
    private ICheckClassMethodCallback mCheckClassMethodCallback;

    static public ProtocolInterpreter getDefault() {
        return Holder.instance;
    }

    static class Holder {
        static ProtocolInterpreter instance = new ProtocolInterpreter();
    }

    private ProtocolInterpreter() {
    }

    /**
     * 初始化，主要用来给mCheckClassMethodCallback赋默认值
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        mCheckClassMethodCallback = new DefaultCheckClassMethodImpl(context);
    }

    /**
     * 设置自定义的错误回调
     * @param checkClassMethodCallback
     */
    public void setCheckClassMethodCallback(ICheckClassMethodCallback checkClassMethodCallback) {
        mCheckClassMethodCallback = checkClassMethodCallback;
    }

    /**
     * 使用入口
     *
     * @param stub interface lei
     * @param <T>  clazz
     * @return obj clazz
     */
    public <T> T create(final Class<T> stub) {
        if (mShadowBeanMap.get(stub) != null) {
            return (T) mShadowBeanMap.get(stub);
        }
        InvocationHandler handler = null;
        try {
            handler = findHandlerByAnnotation(stub);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (handler == null) {
                handler = new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                        if (mCheckClassMethodCallback != null) {
                            mCheckClassMethodCallback.onCheckMethodFail(stub.getName(),
                                "the interface:" + stub.getName() + " do not have any impl");
                        }
                        Log.e(TAG, "the interface:" + stub.getName() + " do not have any impl");
                        return null;
                    }
                };
            }
            T result = (T) Proxy.newProxyInstance(stub.getClassLoader(), new Class[] {stub}, handler);
            mShadowBeanMap.put(stub, result);
            return result;
        }
    }

    /**
     * 通过中间类找到实现类调用
     * @param stub
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     */
    private <T> InvocationHandler findHandlerByAnnotation(final Class<T> stub)
        throws ClassNotFoundException {
        if (mInvocationHandlerMap.keySet().contains(stub)) {
            return mInvocationHandlerMap.get(stub);
        }
        // 从Processor生产的类找到value的返回值(也就是实现类的全路径)
        Annotation annotation = stub.getAnnotation(ProtocolShadow.class);
        Method annotationMethod = null;
        String value = null;
        try {
            annotationMethod = ProtocolShadow.class.getDeclaredMethod("value");
            value = (String) annotationMethod.invoke(annotation);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if (value != null && !"".equals(value)) {
                // 生成中间类
                Class valueClass = Class.forName(ProtocolDataClass.getClassNameForPackage(value));
                // 找到对应的业务类全路径
                String targetClazzName = ProtocolDataClass.getValueFromClass(valueClass);
                if (targetClazzName == null || targetClazzName.equals("") || targetClazzName.equals("null")) {
                    throw new RuntimeException("error! targetClazzName null");
                }
                Log.d(TAG, "==>find Target Class: :" + targetClazzName);
                Object obj = null;
                final Class clazz = Class.forName(targetClazzName);

                // checkMethods
//                checkMethod(stub, clazz);
                if (obj == null) {
                    obj = defaultGetBean(clazz);
                }
                if (obj == null) {
                    throw new RuntimeException("error! obj is null,cannot find action obj in all factory!");
                }
                final Object action = obj;

                InvocationHandler handler = new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                        try {
                            Method realMethod = clazz.getMethod(method.getName(), method.getParameterTypes());
                            realMethod.setAccessible(true);
                            return realMethod.invoke(action, args);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            if (mCheckClassMethodCallback != null) {
                                mCheckClassMethodCallback.onCheckMethodFail(method.getName(), "can not find method:"
                                    + method.getName());
                            }
                            Log.e(TAG, "can not find method:" + method.getName());
                        }
                        return null;
                    }
                };
                mInvocationHandlerMap.put(stub, handler);
                return handler;
            } else {
                return new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                        if (mCheckClassMethodCallback != null) {
                            mCheckClassMethodCallback.onCheckClassFail(stub.getName(),
                                "can not find annotation in class:" + stub.getName());
                        }
                        Log.e(TAG, "can not find annotation in class:" + stub.getName());
                        return null;
                    }
                };
            }
        }
    }


    /**
     * 校验是否存在实现类，与对应的方法
     * 暂时不用，如果找不到实现，直接抛异常节省反射开销
     * @param stub
     * @param clazz
     */
    private void checkMethod(Class stub, Class clazz) {
        try {
            // checkMethods
            List<String> listCheckMethodResult = new ArrayList<>();
            Method[] listMethods = stub.getMethods();
            Method[] listTargetMethods = clazz.getMethods();
            if (listMethods != null && listMethods.length > 0) {
                if (listTargetMethods == null || listTargetMethods.length == 0) {
                    Log.e(TAG, "You maybe miss all methods Imp,Please check it");
                    return;
                }
                for (Method method : listMethods) {
                    String methodName = method.getName();
                    Class<?>[] methodParams = method.getParameterTypes();
                    // 开始匹配
                    boolean bFind = false;
                    for (Method methodTarget : listTargetMethods) {
                        String methodNameTarget = methodTarget.getName();
                        Class<?>[] methodParamsTarget = methodTarget.getParameterTypes();
                        // 方法名一致;
                        if (methodName.equals(methodNameTarget)) {
                            // 参数一致
                            if ((methodParams == null && methodParamsTarget == null)) {
                                bFind = true;
                                break;
                            }
                            // 参数一致
                            if (methodParams != null && methodParamsTarget != null
                                && methodParams.length == methodParamsTarget.length) {
                                int length = methodParams.length;
                                if (length == 0) {
                                    bFind = true;
                                    break;
                                }
                                if (length > 0) {
                                    boolean bFetchWrongParams = false;
                                    for (int i = 0; i < length; i++) {
                                        if (!methodParams[i].getName().equals(methodParamsTarget[i].getName())) {
                                            bFetchWrongParams = true;
                                            break;
                                        }
                                    }
                                    if (!bFetchWrongParams) {
                                        bFind = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (!bFind) {
                        listCheckMethodResult.add(methodName);
                    }
                }
                if (listCheckMethodResult != null && listCheckMethodResult.size() > 0) {
                    StringBuilder errorMessage = new StringBuilder();
                    StringBuilder methods = new StringBuilder();
                    errorMessage.append("can not find methods Imp:");
                    for (String methodName : listCheckMethodResult) {
                        errorMessage.append(methodName).append(",");
                        methods.append(",").append(methodName);
                    }
//                    if (mCheckClassMethodCallback != null) {
//                        mCheckClassMethodCallback.onCheckMethodFail(methods.deleteCharAt(0).toString(),
//                            errorMessage.deleteCharAt(errorMessage.length() - 1).toString());
//                    }
                    Log.e(TAG, errorMessage.toString());
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 缺省采用 无参数构造bean
     * @param clazz
     * @return
     */
    private Object defaultGetBean(Class clazz) {
        try {
            Constructor constructor = clazz.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
