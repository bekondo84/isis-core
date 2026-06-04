package com.teratech.isis.config;

import org.pf4j.PluginManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PluginsRunner implements CommandLineRunner {

    private final PluginManager pluginManager;
    private final PluginControllerManager pluginControllerManager;

    public PluginsRunner(PluginManager pluginManager, PluginControllerManager pluginControllerManager) {
        this.pluginManager = pluginManager;
        this.pluginControllerManager = pluginControllerManager;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("=================================================");
        System.out.println("LE PLUGIN RUNNER S'EXECUTE CORRECTEMENT !");
        System.out.println("=================================================");
          pluginManager.loadPlugins();
          pluginManager.startPlugins();
        // /!\ AJOUT : Enregistrement des endpoints HTTP des plugins
        pluginControllerManager.registerPluginControllers();
    }
}
