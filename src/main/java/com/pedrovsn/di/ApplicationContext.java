package com.pedrovsn.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ApplicationContext {

    public <T> T getInstance(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getConstructor();
        T object = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        injectAnnotadedFields(object, declaredFields);

        return object;
    }

    private <T> void injectAnnotadedFields(T object, Field[] declaredFields) throws Exception {
        for(Field field : declaredFields) {
            if(field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object innerObject = type.getDeclaredConstructor().newInstance();
                field.set(object, innerObject);
                injectAnnotadedFields(innerObject, type.getDeclaredFields());
            }
        }
    }
}
