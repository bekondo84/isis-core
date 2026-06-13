package com.teratech.isis.services.impl;

import com.teratech.ModelServiceException;
import com.teratech.dao.FlexibleSearch;
import com.teratech.extensions.ControllerExtensionPoint;
import com.teratech.extensions.PluginExtensionPoint;
import com.teratech.extensions.ServiceExtensionPoint;
import com.teratech.isis.dao.PluginDao;
import com.teratech.isis.popultor.PluginPopulator;
import com.teratech.model.PluginModel;
import com.teratech.services.PluginService;
import com.teratech.jaxb.entities.Plugin;
import com.teratech.services.JAXBService;
import com.teratech.services.impl.JAXBServiceImpl;
import com.teratech.tools.persistence.RestrictionsContainer;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.pf4j.PluginState;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class PluginServiceImpl implements PluginService {

    private final PluginManager pluginManager;
    private final PluginDao pluginDao;
    private final PluginPopulator pluginPopulator;
    private final FlexibleSearch flexibleSearch;
    private JAXBService jaxbService = new JAXBServiceImpl();
    /**
     *
     * @param pluginManager
     */
    @Autowired
    public PluginServiceImpl(PluginManager pluginManager, PluginDao pluginDao, PluginPopulator pluginPopulator, FlexibleSearch flexibleSearch) {
        this.pluginManager = pluginManager;
        this.pluginDao = pluginDao;
        this.pluginPopulator = pluginPopulator;
        this.flexibleSearch = flexibleSearch;
    }

    /**
     * Execute plugin service
     *
     * @param plugin
     * @param beanName
     * @param methodName
     * @param args
     * @return
     */
    @Override
    public Object execute(String plugin, String beanName, String methodName, Object... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, JAXBException, ClassNotFoundException {
        PluginWrapper pluginWrapper = pluginManager.getPlugin(plugin);

        if (Objects.isNull(pluginWrapper)) {
            throw new IllegalArgumentException(String.format("Not Plugin found with ID %s", plugin));
        }

        List<ServiceExtensionPoint> extensions = this.pluginManager.getExtensions(ServiceExtensionPoint.class, plugin);

        if (extensions.isEmpty()) {
            throw new IllegalArgumentException(String.format("Not ServiceExtensionPoint found for plugin %s", plugin));
        }
        return extensions.get(0).execute(pluginWrapper, beanName, methodName, args);
    }

    /**
     * Refesh the list of available plugins
     *
     * @return
     */
    @Transactional
    @Override
    public String refresh() throws JAXBException, ModelServiceException {
        //Unload all plugin
        pluginManager.unloadPlugins();
        //Reload all the plugins
        pluginManager.loadPlugins();
        //Get all the detected plugins
        List<PluginWrapper> wrappers = pluginManager.getPlugins();

        for (PluginWrapper wrapper : wrappers) {
            RestrictionsContainer container = RestrictionsContainer.newInstance();
            container.addEq("id", wrapper.getPluginId());
            container.addEq("version", wrapper.getDescriptor().getVersion());
            PluginModel pluginModel = (PluginModel) flexibleSearch.find(PluginModel.class, container);

            if (Objects.isNull(pluginModel)) {//Plugin not yet register
                Plugin plugin = jaxbService.getPluginFromResources(wrapper);
                pluginModel = new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion());

                if (Objects.isNull(plugin)) {
                    throw new IllegalArgumentException(String.format("No description file found for plugin %s", wrapper.getPluginId()));
                }
                pluginPopulator.populate(plugin, pluginModel);
                pluginDao.saveORUpdate(pluginModel);
            }
        }
        return "Success";
    }

    /**
     * @return
     */
    @Override
    @Transactional
    public String initialize() throws JAXBException, IllegalAccessException, ModelServiceException, IOException {
        List<PluginModel> records = pluginDao.getAutoInstallPluginsNotYetInstall(0, -1);List<PluginWrapper> wrappers = pluginManager.getPlugins();

        for (PluginModel record : records) {
            PluginWrapper wrapper = pluginManager.getPlugin(record.getId());

            if (Objects.isNull(wrapper)) {
                throw new IllegalStateException(String.format("No plugin found with ID plugin %s, please check if the plugin exists and try again", wrapper.getPluginId()));
            }
            //Install the plugin feature
            install(wrapper.getPluginId(), wrapper.getDescriptor().getVersion());
        }

        return "SUCCES";
    }

    /**
     * Install the plugnid
     *
     * @param plugin
     * @return
     */
    @Transactional
    @Override
    public boolean install(String plugin, String version) throws IOException, JAXBException, IllegalAccessException, ModelServiceException {
        //Start the Plugin
        PluginState pluginState = pluginManager.startPlugin(plugin);

        if (pluginState.isFailed()) {
            throw new IllegalStateException(String.format("Failed to start plugin with id %s", pluginState));
        }
        //Get the PluginExtension
        List<PluginExtensionPoint>  pluginExtensionPoints =  pluginManager.getExtensions(PluginExtensionPoint.class, plugin);
       // System.out.println(pluginManager.getExtensions(ControllerExtensionPoint.class, plugin));
        if (pluginExtensionPoints == null || pluginExtensionPoints.isEmpty()) {
            throw new IllegalArgumentException(String.format("No extension point of type PluginExtensionPoint found for plugin with id : %s", plugin));
        }
        PluginExtensionPoint extensionPoint = pluginExtensionPoints.get(0);
        boolean status = extensionPoint.install(pluginManager.getPlugin(plugin));

        if (status) {
            //Fetch the pluginModel record
            PluginModel pluginModel = (PluginModel) flexibleSearch.find(new PluginModel(plugin, version));
            pluginModel.setInstall(true);
            pluginModel.setInstaldate(new Date());
            pluginDao.saveORUpdate(pluginModel);
        }
        return status;
    }

    /**
     * @param plugin
     * @param version
     * @return
     */
    @Override
    public boolean isInstall(String plugin, String version) {

        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("id", plugin);
        container.addEq("version", plugin);
        PluginModel pluginModel = (PluginModel) flexibleSearch.find(PluginModel.class, container);
        return pluginModel!= null && pluginModel.isInstall() ? true : false;
    }

    /**
     * @param plugin
     * @return
     */
    @Override
    public boolean isInstall(String plugin) {
        PluginWrapper wrapper = pluginManager.getPlugin(plugin);

        if (Objects.isNull(wrapper))
            return false;
        return isInstall(wrapper.getPluginId(), wrapper.getDescriptor().getVersion());
    }

    /**
     * @param start
     * @param max
     * @return
     */
    @Override
    public List getPlugins(int start, int max) {
        return pluginDao.getPlugins(start, max);
    }
}


