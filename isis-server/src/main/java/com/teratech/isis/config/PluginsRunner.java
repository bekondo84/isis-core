package com.teratech.isis.config;

import org.pf4j.PluginManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PluginsRunner implements CommandLineRunner {

    private final PluginManager pluginManager;
    private final RestPluginManager restPluginManager;
    private final org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping;
    public PluginsRunner(PluginManager pluginManager, RestPluginManager restPluginManager, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.pluginManager = pluginManager;
        this.restPluginManager = restPluginManager;
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("=================================================");
        System.out.println("LE PLUGIN RUNNER S'EXECUTE CORRECTEMENT !");
        System.out.println("=================================================");
          pluginManager.loadPlugins();
          pluginManager.startPlugins();
        // /!\ AJOUT : Enregistrement des endpoints HTTP des plugins
        restPluginManager.registerPluginControllers();

        // 2. LE TEST : Affichage de TOUTES les routes connues par Spring
        System.out.println("\n========== [DIAGNOSTIC : CATALOGUE DES ROUTES SPRING] ==========");
        requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
            System.out.println("[Route Active] -> " + key + " | Associée au composant : " + value.getShortLogMessage());
        });
        System.out.println("=================================================================\n");
    }
}
