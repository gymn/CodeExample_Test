package com.gymn.annotation;

import java.lang.reflect.Field;

public class ParseInfo {
    public static String getInfo(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder info = new StringBuilder();
        for(Field field: fields){
            if(field.isAnnotationPresent(Properties.class)){
                Properties properties = field.getAnnotation(Properties.class);
                String name = properties.name();
                int age = properties.age();
                info.append("name:"+name+"\n");
                info.append("age:"+age+"\n");
            }
        }
        info.append("end");
        return info.toString();
    }
}
