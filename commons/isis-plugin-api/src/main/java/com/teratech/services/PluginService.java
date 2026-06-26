package com.teratech.services;

import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.model.PluginModel;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface PluginService {

    static final String GET_DEPENDS = "SELECT p FROM PluginModel p WHERE :pluginId MEMBER OF p.dependencies";

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
    String refresh() throws JAXBException, ModelServiceException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException;
    /**
     *
     * @return
     * @throws JAXBException
     */
    String initialize() throws JAXBException, IllegalAccessException, ModelServiceException, IOException, NoSuchFieldException, InstantiationException, InvocationTargetException, NoSuchMethodException;

    /**
     * Install the plugnid
     * @param pluginid
     * @return
     */
    boolean install (final String pluginid) throws ApplicationException;

    /**
     *
     * @param pluginId
     * @return
     * @throws ApplicationException
     */
    boolean uninstall (final String pluginId) throws ApplicationException, IllegalAccessException;
    /**
     *
     * @param plugin
     * @param version
     * @return
     */
    boolean isInstall(final String plugin, String version) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException;

    /**
     *
     * @param plugin
     * @return
     */
    boolean isInstall(final String plugin) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException;

    /**
     *
     * @param start
     * @param max
     * @return
     */
    List  getPlugins(int start, int max) throws IllegalAccessException;

    /**
     *
     * @param pluginid
     * @return
     * @throws IllegalAccessException
     */
    List<PluginModel> getDependesOf (String pluginid) throws IllegalAccessException;

    /**
     *
     * @param id
     * @param version
     * @return
     */
    PluginModel getPlugin (String id, String version) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException;
}
