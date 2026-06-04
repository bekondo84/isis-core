package com.teratech.isis.services.impl;

import com.teratech.extensions.ServiceExtensionPoint;
import com.teratech.isis.services.PluginService;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
    public Object execute(String plugin, String beanName, String methodName, Object... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<ServiceExtensionPoint> extensions = this.pluginManager.getExtensions(ServiceExtensionPoint.class);
        Optional<ServiceExtensionPoint>  extensionPoint = extensions.stream().filter(ext -> ext.plugin().equalsIgnoreCase(plugin)).findAny();

        if (extensionPoint.isEmpty()) {
            throw new IllegalArgumentException(String.format("Not Extension Point found for plugin %s", plugin));
        }
        return extensionPoint.get().execute(beanName, methodName, args);
    }
}
