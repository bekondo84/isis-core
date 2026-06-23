package com.teratech.utils;

import org.pf4j.PluginWrapper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
