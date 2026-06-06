package com.teratech.isis.services.impl;

import com.teratech.extensions.ServiceExtensionPoint;
import com.teratech.isis.services.PluginService;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PluginServiceImpl implements PluginService {

    private final PluginManager pluginManager;

    /**
     *
     * @param pluginManager
     */
    @Autowired
    public PluginServiceImpl(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
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
}
