package com.teratech.isis.services.impl;

import com.teratech.extensions.PluginExtensionPoint;
import com.teratech.extensions.ServiceExtensionPoint;
import com.teratech.isis.dao.PluginDao;
import com.teratech.isis.popultor.PluginPopulator;
import com.teratech.model.PluginModel;
import com.teratech.services.PluginService;
import com.teratech.jaxb.entities.Plugin;
import com.teratech.services.JAXBService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PluginServiceImpl implements PluginService {

    private final PluginManager pluginManager;
    private final PluginDao pluginDao;
    private final PluginPopulator pluginPopulator;
    /**
     *
     * @param pluginManager
     */
    @Autowired
    public PluginServiceImpl(PluginManager pluginManager, PluginDao pluginDao, PluginPopulator pluginPopulator) {
        this.pluginManager = pluginManager;
        this.pluginDao = pluginDao;
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
     * @return
     */
    @Override
    @Transactional
    public String initialize() throws JAXBException {
        JAXBService jaxbService = new JAXBServiceImpl();
        List<PluginWrapper> wrappers = pluginManager.getPlugins();

        for (PluginWrapper wrapper : wrappers) {
            Plugin plugin = jaxbService.getPluginFromResources(wrapper);
            boolean create = false ;
            if (Objects.isNull(plugin)) {
                throw new IllegalStateException(String.format("No plugin definition found for plugin %s, please check if the plugin is well configure", wrapper.getPluginId()));
            }

            PluginModel pluginModel = pluginDao.getPlugin(wrapper.getPluginId(), wrapper.getDescriptor().getVersion());
            if (Objects.isNull(pluginModel)) {
                create = true;
                pluginModel = new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion());
            }
            pluginPopulator.populate(plugin, pluginModel);

            if (plugin.isAutoInstall()) {
                pluginModel.setInstall(true);
                pluginModel.setInstaldate(new Date());
            }
            pluginDao.saveORUpdate(pluginModel, create);
        }
        return "SUCCES";
    }

    /**
     * Install the plugnid
     *
     * @param pluginid
     * @return
     */
    @Override
    public boolean install(String pluginid, String version) throws IOException {
        List<PluginExtensionPoint>  pluginExtensionPoints =  pluginManager.getExtensions(PluginExtensionPoint.class, pluginid);

        if (pluginExtensionPoints == null || pluginExtensionPoints.isEmpty()) {
            throw new IllegalArgumentException(String.format("No PluginExtensionPoint of type found for plugin with id : %s", pluginid));
        }
        PluginExtensionPoint extensionPoint = pluginExtensionPoints.get(0);
        return extensionPoint.install(pluginManager.getPlugin(pluginid));
    }
}


