package com.meitu.library.modularprotocol;

/**
 * 通过动态代理和反射寻找实现类时的失败回调
 * Created by yangsq on 2017/5/31.
 */

public interface ICheckClassMethodCallback {
    void onCheckClassFail(String targetClassName, String msg);

    void onCheckMethodFail(String targetMethodName, String msg);
}
