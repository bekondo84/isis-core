package com.teratech.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtils {

    public static List<Field> getDeclaredFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();
        Class<?> currentType = type;

        while (!currentType.equals(Object.class)) {
            fields.addAll(Arrays.asList(currentType.getDeclaredFields()));
            currentType = currentType.getSuperclass();
        }

        return fields;
    }
    /**
     * Return le type généric pour les collections
     * @param field
     * @return
     */
    public static Class getGenericType(Field field) {
        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
        Class<?> elementType = (Class<?>) parameterizedType.getActualTypeArguments()[0];
        return elementType;
    }

    /**
     * Return true si ma class est une interface ou une class abstraite
     * @param clazz
     * @return
     */
    public static boolean isNotConcrete(Class<?> clazz) {
        int modifiers = clazz.getModifiers();
        return Modifier.isAbstract(modifiers) || Modifier.isInterface(modifiers) ;
    }
}
