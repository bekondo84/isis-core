package com.teratech.utils;

import org.pf4j.PluginWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ClassUtils {

    /**
     * Chargement de la class
     * @param wrapper
     * @param classname
     * @return
     * @throws ClassNotFoundException
     */
    public static Class<?> loadClass (final PluginWrapper wrapper, String classname) throws ClassNotFoundException {
        ClassLoader clazzLoader = Thread.currentThread().getContextClassLoader();

        if (Objects.nonNull(wrapper)) {
            clazzLoader = wrapper.getPluginClassLoader();
        }
        return clazzLoader.loadClass(classname);
    }

    /**
     *
     * @param entityClazz
     * @param fieldname
     * @return
     * @throws NoSuchFieldException
     */
    public static  Field getFieldFrom(Class entityClazz, String fieldname) throws NoSuchFieldException {
        Class itemClass = entityClazz ;

        while (!itemClass.equals(Object.class)) {
            Optional fieldop = Arrays.asList(itemClass.getDeclaredFields())
                    .stream().filter(field -> field.getName().equals(fieldname)).findAny();
            if (fieldop.isPresent()) {
                return (Field) fieldop.get();
            }
            itemClass = itemClass.getSuperclass();
        }
        return null;
    }
    /**
     *
     * @param clazz
     * @return
     */
    public static List<Method> getMethodsFor (Class clazz) {
        final List<Method> methods = new ArrayList<>();
        Class currentClass = clazz ;

        while (!currentClass.equals(Object.class)) {
            System.out.println(String.format("---------CurrentClass : %s", currentClass));
            methods.addAll(Arrays.asList(currentClass.getDeclaredMethods()));
            currentClass = currentClass.getSuperclass();
        }
        return methods;
    }
}
