package com.teratech.isis.config;

import org.apache.commons.lang.BooleanUtils;
import org.pf4j.PluginManager;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class PluginsRunner implements CommandLineRunner {

    private final PluginManager pluginManager;
    private final RestPluginManager restPluginManager;
    private final org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final Logger logger;
    private final Environment env ;

    /**
     *
     * @param pluginManager
     * @param restPluginManager
     * @param requestMappingHandlerMapping
     * @param logger
     */
    public PluginsRunner(PluginManager pluginManager, RestPluginManager restPluginManager, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping, Logger logger, Environment env) {
        this.pluginManager = pluginManager;
        this.restPluginManager = restPluginManager;
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.logger = logger;
        this.env = env;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("DEMARRAGE DES PLUGINS EN COURS !!!!!!!!");
          pluginManager.loadPlugins();
          pluginManager.startPlugins();
        // /!\ AJOUT : Enregistrement des endpoints HTTP des plugins
        restPluginManager.registerPluginControllers();
        logger.info("LES PLUGINS CORRECTEMENT DEMARREES !");

        // 2. LE TEST : Affichage de TOUTES les routes connues par Spring
        if (BooleanUtils.toBoolean(env.getProperty("spring.web.show-routes"))) {
            logger.info("\n========== [CATALOGUE OF SPRING ROAD] ==========");
            requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
                logger.info("[Active Road] -> " + key + " | Associate component : " + value.getShortLogMessage());
            });
            System.out.println("=================================================================\n");
        }
    }
}
