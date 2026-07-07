package com.teratech.isis.services.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.exceptions.ApplicationException;
import com.teratech.model.rules.BusinessRuleModel;
import com.teratech.services.RuleEngineService;
import com.teratech.tools.persistence.RestrictionsContainer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RuleEngineServiceImpl implements RuleEngineService {

    private final FlexibleSearch flexibleSearch;
    private final Logger logger;
    private final KieServices kieServices = KieServices.Factory.get();

    // Cache pour éviter de recompiler le DRL à chaque appel
    private final Map<String, KieContainer> cache = new ConcurrentHashMap<>();
    /**
     *
     * @param flexibleSearch
     */
    public RuleEngineServiceImpl(FlexibleSearch flexibleSearch, Logger logger) {
        this.flexibleSearch = flexibleSearch;
        this.logger = logger;
    }

    /**
     * Execute rule group
     *
     * @param ruleGroup : group of rules to load
     * @param facts
     */
    @Override
    public void executeRules(String ruleGroup, List<Object> facts, ClassLoader pluginClassLoader) throws ApplicationException {
        try {
            KieContainer kieContainer = cache.computeIfAbsent(ruleGroup, group -> buildKieContainerForGroup(ruleGroup, pluginClassLoader));

            KieSession kieSession = kieContainer.newKieSession();
            try {
                for (Object fact : facts) {
                    kieSession.insert(fact);
                }
                kieSession.fireAllRules();
            } finally {
                kieSession.dispose();
            }
        } catch (RuntimeException ex) {
            throw new  ApplicationException(ex);
        }
    }

    private KieContainer buildKieContainerForGroup (String ruleGroup, ClassLoader pluginClassLoader)  {

        try {
            RestrictionsContainer container = RestrictionsContainer.newInstance();
            container.addEq("group", ruleGroup);
            container.addEq("actif", Boolean.TRUE);

            List<BusinessRuleModel> rules = flexibleSearch.doSearch(BusinessRuleModel.class, container, new HashMap<>(), new HashSet<>(), 0, -1);

            if (CollectionUtils.isEmpty(rules)) {
                logger.info(String.format("No BusinessRule found for group %s", ruleGroup));
                return null;
            }

            KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
            int index = 0;
            for (BusinessRuleModel rule : rules) {
                String virtualPath = "src/main/resources/rules/" + ruleGroup + "/rule_" + (index++) + ".drl";
                kieFileSystem.write(virtualPath, rule.getRule());
            }

            KieBuilder kieBuilder = null;

            if (Objects.isNull(pluginClassLoader)) {
                kieServices.newKieBuilder(kieFileSystem);
            } else {
                kieServices.newKieBuilder(kieFileSystem, pluginClassLoader);
            }
            kieBuilder.buildAll();

            if (kieBuilder.getResults().hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
                throw new RuntimeException("Drools compilation errors : " + kieBuilder.getResults().toString());
            }

            KieModule kieModule = kieBuilder.getKieModule();

            if (Objects.isNull(pluginClassLoader)) {
                return kieServices.newKieContainer(kieModule.getReleaseId());
            }
            //If the pluginClassLoader not null
            return kieServices.newKieContainer(kieModule.getReleaseId(), pluginClassLoader);

        } catch (Exception  e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode à appeler si vous modifiez une règle en BD pour forcer la mise à jour
    public void evictCache(String ruleGroup) {
        cache.remove(ruleGroup);
    }
}

