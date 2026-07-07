package com.teratech.services;

import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public interface I18NService {

    static final Logger LOG = LoggerFactory.getLogger(I18NService.class);

    default String getMessage (String pluginId, String key) {
        PluginWrapper pluginWrapper = null ;
        if (!StringUtils.isBlank(pluginId)) {
            pluginWrapper = getPluginManger().getPlugin(pluginId);
            assert Objects.nonNull(pluginWrapper) : String.format("No plugin found for id %s", pluginId);
        }
        return getMessage(pluginWrapper, key);
    }

    default String getMessage (PluginWrapper pluginWrapper, String key) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (!Objects.nonNull(pluginWrapper)) {
            classLoader = pluginWrapper.getPluginClassLoader();
        }

        try {
            ResourceBundle resource = ResourceBundle.getBundle("messages", Locale.getDefault(), classLoader);
            final String message = resource.getString(key);
            return StringUtils.isNotBlank(message) ? message : key;
        } catch (MissingResourceException ex) {
            LOG.error(ex.getMessage());
            return key;
        }
    }

    PluginManager getPluginManger();

}
