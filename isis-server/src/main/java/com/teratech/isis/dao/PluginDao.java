package com.teratech.isis.dao;

import com.teratech.exceptions.ModelServiceException;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.model.PluginModel;
import com.teratech.tools.persistence.RestrictionsContainer;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public interface PluginDao {

    static final String GET_DEPENDS = "SELECT p FROM PluginModel p WHERE :pluginId MEMBER OF p.dependencies";

    /**
     *
     * @param start
     * @param max
     * @return
     */
   default List<PluginModel> getPlugins(int start, int max) throws IllegalAccessException {
       return getFlexibleSearch().doSearch(PluginModel.class, RestrictionsContainer.newInstance(), new HashMap<>(), new HashSet<>(), start, max);//getEm().createQuery("SELECT m FROM PluginModel m", PluginModel.class).getResultList();
   }

    /**
     *
     * @param startAt
     * @param max
     * @return
     */
   default List<PluginModel> getInstallPlugins(int startAt, int  max) throws IllegalAccessException {
       RestrictionsContainer container = RestrictionsContainer.newInstance();
       container.addEq("install", Boolean.TRUE);
       return getFlexibleSearch().doSearch(PluginModel.class, container, new HashMap<>(), new HashSet<>(), startAt, max);
   }

    /**
     *
     * @param startAt
     * @param max
     * @return
     */
   default List<PluginModel> getAutoInstallPluginsNotYetInstall(int startAt, int max) throws IllegalAccessException {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("install", Boolean.FALSE);
        container.addEq("autoInstall", Boolean.TRUE);
        return getFlexibleSearch().doSearch(PluginModel.class, container, new HashMap<>(), new HashSet<>(), startAt, max);
   }

    /**
     *
     * @param id
     * @param version
     * @return
     * @throws IllegalAccessException
     */
   default PluginModel getPlugin(String id, String version) throws IllegalAccessException, NoSuchFieldException, InstantiationException, InvocationTargetException, NoSuchMethodException {
       return (PluginModel) getFlexibleSearch().find(new PluginModel(id, version));
   }

    /**
     *
     * @param plugin
     * @return
     * @throws ModelServiceException
     */
   default PluginModel saveORUpdate(PluginModel plugin) throws ModelServiceException {
       try {
           getPersistenceManager().save(plugin);
       } catch (IllegalAccessException | NoSuchFieldException e) {
           throw new ModelServiceException(e);
       }
       return plugin;
   }

    /**
     *
     * @param pluginid
     * @return
     * @throws IllegalAccessException
     */
   default  List<PluginModel> getDependesOf (String pluginid) throws IllegalAccessException {
       return getFlexibleSearch().doSearch(GET_DEPENDS, Collections.singletonMap("pluginId", pluginid));
   }

   FlexibleSearch getFlexibleSearch();
   PersistenceManager getPersistenceManager();
}
