package com.meitu.library.modularprotocol;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by hxd on 16/6/13.
 */
public class ProtocolDataClass {
    /**
     * 生成类的固定生成路径
     */
    public static String packageName = "com.meitu.library.modularprotocol.data";

    public ProtocolDataClass() {

    }

    /**
     * 获取生成类的完整路径
     * @param simpleName
     * @return
     */
    public static String getClassNameForPackage(String simpleName) {
        return packageName + "." + simpleName;
    }

    /**
     * 通过注解获取类的value属性值
     * @param middleClass
     * @return
     */
    public static String getValueFromClass(Class middleClass) {
        try {
            Field field = middleClass.getDeclaredField("value");
            return (String) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成中间类
     * @param packageName
     * @param middleClassName
     * @param value
     * @return
     */
    public String generateMiddleClass(String packageName, String middleClassName, String value) {
        StringBuilder builder = new StringBuilder();
        builder.append("// Generated code from ModularProtocol SDK. Do not modify!\n");
        builder.append("package ").append(packageName).append(";\n\n");

        builder.append("import java.lang.String;\n");
        builder.append("public class ").append(middleClassName).append("{\n");

        builder.append("  public static String value=\"").append(value).append("\";\n");

        builder.append("}\n");
        return builder.toString();

    }
}
