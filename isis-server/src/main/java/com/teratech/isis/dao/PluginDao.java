package com.teratech.isis.dao;

import com.teratech.model.PluginId;
import com.teratech.model.PluginModel;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface PluginDao {

   default List<PluginModel> getAllPlugins() {
       return getEm().createQuery("SELECT m FROM PluginModel m", PluginModel.class).getResultList();
   }

   default List<PluginModel> getInstallPlugins() {
       return getEm().createQuery("SELECT m FROM PluginModel m WHERE m.install = true", PluginModel.class).getResultList();
   }

   default PluginModel getPlugin(String id, String version) {
       return getEm().find(PluginModel.class, new PluginId(id, version));
   }

   default PluginModel saveORUpdate(PluginModel plugin, boolean create) {

       if (create)
           getEm().persist(plugin);
       else
           getEm().merge(plugin);
       return plugin;
   }

    EntityManager getEm();
}
