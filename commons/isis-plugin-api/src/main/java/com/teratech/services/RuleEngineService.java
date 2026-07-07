package com.teratech.services;

import com.teratech.exceptions.ApplicationException;
import com.teratech.model.PluginModel;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;

import java.util.List;

public interface RuleEngineService {

    /**
     * Execute rule group
     * @param ruleGroup : group of rules to load
     * @param facts
     * @param pluginClassLoader
     */
    void executeRules (final String ruleGroup, List<Object> facts, ClassLoader pluginClassLoader) throws ApplicationException;


}
