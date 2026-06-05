package com.teratech.isis.config;

import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

@Configuration
public class PluginStaticResourceConfig implements WebMvcConfigurer {

    private final PluginManager pluginManager;

    public PluginStaticResourceConfig(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Une seule route globale interceptée par le Core
        registry.addResourceHandler("/plugins-assets/**")
                .addResourceLocations("classpath:/static/plugins/") // Emplacement théorique par défaut
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        // resourcePath ressemble à : "admin-plugin/css/style.css"

                        int firstSlash = resourcePath.indexOf('/');
                        if (firstSlash != -1) {
                            // 1. Extraction de l'ID du plugin depuis l'URL
                            String pluginId = resourcePath.substring(0, firstSlash);

                            // 2. Récupération du plugin via PF4J
                            PluginWrapper pluginWrapper = pluginManager.getPlugin(pluginId);

                            if (pluginWrapper != null) {
                                // 3. Reconstruction du chemin interne du fichier dans le JAR
                                // ex: "static/plugins/admin-plugin/css/style.css"
                                String internalPath = "static/plugins/" + resourcePath;

                                // 4. CRUCIAL : On charge la ressource en utilisant le ClassLoader du plugin
                                Resource resource = new ClassPathResource(internalPath, pluginWrapper.getPluginClassLoader());

                                if (resource.exists() && resource.isReadable()) {
                                    return resource;
                                }
                            }
                        }
                        return null; // Passe au résolveur suivant (ou 404 standard)
                    }
                });

        System.out.println("[Core-UI] Moteur de ressources statiques dynamiques PF4J initialisé.");
    }
}
