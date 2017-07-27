package com.meitu.library.modularprotocol;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

/**
 * main processor for annotation
 * Created by hxd on 16/3/28.
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ProtocolProcessor extends AbstractProcessor {
    Elements elementUtils;
    Types typeUtils;
    Filer filer;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        processProtocol(roundEnv);
        return true;
    }

    private static class ElementHolder {
        String clazzName;

        public ElementHolder(String clazzName) {
            this.clazzName = clazzName;
        }
    }

    /**
     * 生成中间类
     * @param roundEnv env
     */
    private void processProtocol(RoundEnvironment roundEnv) {
        Map<String, ElementHolder> protocolMap = collectClassInfo(roundEnv, Protocol.class, ElementKind.CLASS);
        if (protocolMap.keySet().size() == 0) {
            System.out.println("find Protocol size 0");
            // return;
        }

        for (String value : protocolMap.keySet()) {
            System.out.println("create file for protocol  " + value);
            ProtocolDataClass protocolDataClass = new ProtocolDataClass();
            try {
                JavaFileObject fileObject = filer.createSourceFile(value, (Element[]) null);
                Writer writer = fileObject.openWriter();
                writer.write(protocolDataClass.generateMiddleClass(ProtocolDataClass.packageName, value,
                    protocolMap.get(value).clazzName));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取所有相关注解的类信息
     * @param roundEnv
     * @param clazz
     * @param kind
     * @return
     */
    private Map<String, ElementHolder> collectClassInfo(RoundEnvironment roundEnv, Class<? extends Annotation> clazz,
        ElementKind kind) {
        System.out.println("collectClassInfo for" + clazz.getSimpleName());
        Map<String, ElementHolder> map = new HashMap<>();
        for (Element element : roundEnv.getElementsAnnotatedWith(clazz)) {
            if (element.getKind() != kind) {
                throw new IllegalStateException(String.format("@%s annotation must be on a  %s.",
                    element.getSimpleName(), kind.name()));
            }
            try {

                TypeElement typeElement = (TypeElement) element;
                Annotation annotation = element.getAnnotation(clazz);
                String clazzName = typeElement.getQualifiedName().toString();
                Method annotationMethod = clazz.getDeclaredMethod("value");
                String name = (String) annotationMethod.invoke(annotation);
                map.put(name, new ElementHolder(clazzName));
                System.out.println("get Annotation  clazzName:" + clazzName);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return map;
    }

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        elementUtils = env.getElementUtils();
        typeUtils = env.getTypeUtils();
        filer = env.getFiler();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<String>();
        types.add(Protocol.class.getCanonicalName());
        types.add(ProtocolShadow.class.getCanonicalName());
        return types;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
