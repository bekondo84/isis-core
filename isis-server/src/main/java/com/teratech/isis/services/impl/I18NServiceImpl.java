package com.teratech.isis.services.impl;

import com.teratech.services.I18NService;
import org.pf4j.PluginManager;
import org.springframework.stereotype.Service;

@Service
public class I18NServiceImpl implements I18NService {

    private final PluginManager pluginManager;

    /**
     *
     * @param pluginManager
     */
    public I18NServiceImpl(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    /**
     * @return
     */
    @Override
    public PluginManager getPluginManger() {
        return pluginManager;
    }
}
