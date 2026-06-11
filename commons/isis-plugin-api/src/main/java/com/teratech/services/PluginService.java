package com.teratech.services;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
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

    /**
     *
     * @return
     * @throws JAXBException
     */
    String initialize() throws JAXBException;

    /**
     * Install the plugnid
     * @param pluginid
     * @return
     */
    boolean install (final String pluginid, String version) throws IOException;
}
