package com.teratech.isis.services;

import jakarta.xml.bind.JAXBException;

import java.lang.reflect.InvocationTargetException;

public interface PluginService {

    /**
     * Execute plugin service
     * @param plugin
     * @param beanName
     * @param methodName
     * @param args
     * @return
     */
    Object execute(final String plugin, final String beanName, final String methodName, Object...args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, JAXBException, ClassNotFoundException;
}
