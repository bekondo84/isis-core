package com.teratech.isis.config;

import com.teratech.isis.dao.PluginDao;
import com.teratech.isis.model.PluginModel;
import org.apache.commons.lang.BooleanUtils;
import org.pf4j.PluginManager;
import org.pf4j.PluginState;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Configuration
public class PluginsRunner implements CommandLineRunner {

    private final PluginManager pluginManager;
    private final RestPluginManager restPluginManager;
    private final org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final Logger logger;
    private final Environment env ;
    private final PluginDao pluginDao;

    /**
     *
     * @param pluginManager
     * @param restPluginManager
     * @param requestMappingHandlerMapping
     * @param logger
     */
    public PluginsRunner(PluginManager pluginManager, RestPluginManager restPluginManager, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping, Logger logger, Environment env, PluginDao pluginDao) {
        this.pluginManager = pluginManager;
        this.restPluginManager = restPluginManager;
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.logger = logger;
        this.env = env;
        this.pluginDao = pluginDao;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("DEMARRAGE DES PLUGINS EN COURS !!!!!!!!");
          pluginManager.loadPlugins();
          pluginManager.getPlugins().forEach(wrapper -> System.out.println(wrapper.getPluginId()));
          startInstallPlugins();
          //pluginManager.startPlugins();
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

    private void startInstallPlugins() {
        List<PluginModel> installPlugins = pluginDao.getInstallPlugins();

        if (installPlugins != null && !installPlugins.isEmpty()) {

            for (PluginModel pg : installPlugins) {

                if (Objects.nonNull(pluginManager.getPlugin(pg.getId()))) {
                    PluginState state = pluginManager.startPlugin(pg.getId());
                    if (state.isStarted()) {
                        logger.info(String.format("[CORE-] - Plugin %s has started succesfuly", pg.getId()));
                    } else if (state.isFailed()){
                        logger.info(String.format("[CORE-] - Plugin %s has failed start", pg.getId()));
                    }
                }
            }
        }
    }
}
