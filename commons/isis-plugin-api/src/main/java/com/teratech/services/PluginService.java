package com.teratech.services;

import com.teratech.ModelServiceException;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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
     * Refesh the list of available plugins
     * @return
     */
    String refresh() throws JAXBException, ModelServiceException, NoSuchFieldException, IllegalAccessException, InstantiationException;
    /**
     *
     * @return
     * @throws JAXBException
     */
    String initialize() throws JAXBException, IllegalAccessException, ModelServiceException, IOException, NoSuchFieldException, InstantiationException;

    /**
     * Install the plugnid
     * @param pluginid
     * @return
     */
    boolean install (final String pluginid, String version) throws IOException, JAXBException, IllegalAccessException, ModelServiceException, NoSuchFieldException, InstantiationException;

    /**
     *
     * @param plugin
     * @param version
     * @return
     */
    boolean isInstall(final String plugin, String version) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    /**
     *
     * @param plugin
     * @return
     */
    boolean isInstall(final String plugin) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    /**
     *
     * @param start
     * @param max
     * @return
     */
    List  getPlugins(int start, int max) throws IllegalAccessException;
}
