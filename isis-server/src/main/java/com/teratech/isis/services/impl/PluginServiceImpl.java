package com.teratech.isis.services.impl;

import com.teratech.beans.PluginData;
import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.dao.FlexibleSearch;
import com.teratech.extensions.PluginExtensionPoint;
import com.teratech.extensions.ServiceExtensionPoint;
import com.teratech.isis.dao.PluginDao;
import com.teratech.isis.popultor.PluginJAXBPopulator;
import com.teratech.isis.popultor.PluginPopulator;
import com.teratech.model.PluginModel;
import com.teratech.services.MenuNodeService;
import com.teratech.services.PluginService;
import com.teratech.jaxb.entities.Plugin;
import com.teratech.services.JAXBService;
import com.teratech.services.impl.JAXBServiceImpl;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.pf4j.PluginState;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PluginServiceImpl implements PluginService {

    private final PluginManager pluginManager;
    private final PluginDao pluginDao;
    private final PluginJAXBPopulator pluginJAXBPopulator;
    private final FlexibleSearch flexibleSearch;
    private final MenuNodeService menuNodeService;
    private final PluginPopulator pluginPopulator;
    private JAXBService jaxbService = new JAXBServiceImpl();
    /**
     *
     * @param pluginManager
     */
    @Autowired
    public PluginServiceImpl(PluginManager pluginManager, PluginDao pluginDao, PluginJAXBPopulator pluginJAXBPopulator, FlexibleSearch flexibleSearch, MenuNodeService menuNodeService, PluginPopulator pluginPopulator) {
        this.pluginManager = pluginManager;
        this.pluginDao = pluginDao;
        this.pluginJAXBPopulator = pluginJAXBPopulator;
        this.flexibleSearch = flexibleSearch;
        this.menuNodeService = menuNodeService;
        this.pluginPopulator = pluginPopulator;
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
    public String refresh() throws JAXBException, ModelServiceException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        //Unload all plugin
        pluginManager.unloadPlugins();
        //Reload all the plugins
        pluginManager.loadPlugins();
        //Get all the detected plugins
        List<PluginWrapper> wrappers = pluginManager.getPlugins();

        for (PluginWrapper wrapper : wrappers) {
            PluginModel pluginModel = (PluginModel) flexibleSearch.find(new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion()));

            if (Objects.isNull(pluginModel)) {//Plugin not yet register
                Plugin plugin = jaxbService.getPluginFromResources(wrapper);
                pluginModel = new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion());

                if (Objects.isNull(plugin)) {
                    throw new IllegalArgumentException(String.format("No description file found for plugin %s", wrapper.getPluginId()));
                }
                pluginJAXBPopulator.populate(plugin, pluginModel);
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
    public String initialize() throws JAXBException, IllegalAccessException, ModelServiceException, IOException, NoSuchFieldException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        List<PluginModel> records = pluginDao.getAutoInstallPluginsNotYetInstall(0, -1);List<PluginWrapper> wrappers = pluginManager.getPlugins();

        for (PluginModel record : records) {
            PluginWrapper wrapper = pluginManager.getPlugin(record.getId());

            if (Objects.isNull(wrapper)) {
                throw new IllegalStateException(String.format("No plugin found with ID plugin %s, please check if the plugin exists and try again", wrapper.getPluginId()));
            }
            //Install the plugin feature
            //install(wrapper.getPluginId());
        }

        return "SUCCES";
    }

    /**
     * @param pluginId
     * @return
     * @throws ApplicationException
     */
    @Override
    public boolean uninstall(String pluginId) throws ApplicationException, IllegalAccessException {
        List<PluginModel> depends = getDependesOf(pluginId);

        if (!CollectionUtils.isEmpty(depends)) {
            List<String> installdepends = depends.stream().filter(plug -> plug.isInstall()).map(plug -> plug.getId()).collect(Collectors.toUnmodifiableList());
            if (!CollectionUtils.isEmpty(installdepends))
                throw new ApplicationException(String.format("These plugins %s depends on %s, Please uninstall it and try again", installdepends, pluginId));
        }
        //Get the PluginExtension
        List<PluginExtensionPoint>  pluginExtensionPoints =  pluginManager.getExtensions(PluginExtensionPoint.class, pluginId);
        //System.out.println(pluginManager.getExtensions(plugin));
        if (pluginExtensionPoints == null || pluginExtensionPoints.isEmpty()) {
            throw new IllegalArgumentException(String.format("No extension point of type PluginExtensionPoint found for plugin with id : %s", pluginId));
        }
        PluginExtensionPoint extensionPoint = pluginExtensionPoints.get(0);

        return extensionPoint.uninstall(pluginManager.getPlugin(pluginId));
    }

    /**
     * Install the plugnid
     *
     * @param plugin
     * @return
     */
    //@Transactional
    @Override
    public boolean install(String plugin) throws ApplicationException {
        //Start the Plugin
        PluginState pluginState = pluginManager.startPlugin(plugin);
        PluginWrapper wrapper = pluginManager.getPlugin(plugin);


        if (pluginState.isFailed()) {
            throw new IllegalStateException(String.format("Failed to start plugin with id %s", pluginState));
        }

        //*******************************
        ClassLoader loader =
                wrapper.getPluginClassLoader();

        try (ScanResult scan =
                     new ClassGraph()
                             .overrideClassLoaders(loader)
                             .enableClassInfo()
                             .scan()) {

            for (ClassInfo ci :
                    scan.getAllClasses()) {

                System.out.println(ci.getName());
            }
        }
        //Get the PluginExtension
        List<PluginExtensionPoint>  pluginExtensionPoints =  pluginManager.getExtensions(PluginExtensionPoint.class, plugin);
       //System.out.println(pluginManager.getExtensions(plugin));
        if (pluginExtensionPoints == null || pluginExtensionPoints.isEmpty()) {
            throw new IllegalArgumentException(String.format("No extension point of type PluginExtensionPoint found for plugin with id : %s", plugin));
        }
        PluginExtensionPoint extensionPoint = pluginExtensionPoints.get(0);

        return extensionPoint.install(pluginManager.getPlugin(plugin));
    }

    /**
     * @param plugin
     * @param version
     * @return
     */
    @Override
    public boolean isInstall(String plugin, String version) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        PluginModel pluginModel = (PluginModel) flexibleSearch.find(new PluginModel(plugin, version));
        return pluginModel!= null && pluginModel.isInstall() ? true : false;
    }

    /**
     * @param plugin
     * @return
     */
    @Override
    public boolean isInstall(String plugin) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
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
    public List getPlugins(int start, int max) throws IllegalAccessException {
        return pluginDao.getPlugins(start, max);
    }

    /**
     * @param pluginid
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public List<PluginModel> getDependesOf(String pluginid) throws IllegalAccessException {
        return flexibleSearch.doSearch(GET_DEPENDS, Collections.singletonMap("pluginId", pluginid));
    }

    /**
     * @param id
     * @param version
     * @return
     */
    @Override
    public PluginModel getPlugin(String id, String version) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        return flexibleSearch.find(new PluginModel(id, version));
    }

    /**
     * Load Plugin informations
     *
     * @param pluginId
     * @return
     */
    @Override
    public PluginData loadPlugin(String pluginId) throws ModelServiceException {

        try {
            PluginWrapper pluginWrapper = pluginManager.getPlugin(pluginId);
            PluginModel pluginModel = flexibleSearch.find(new PluginModel(pluginId, pluginWrapper.getDescriptor().getVersion()));
            final PluginData pluginData = new PluginData();
            pluginPopulator.populate(pluginModel, pluginData);

            return pluginData;
        } catch (Exception e) {
              throw new ModelServiceException(e);
        }
        
    }
}


