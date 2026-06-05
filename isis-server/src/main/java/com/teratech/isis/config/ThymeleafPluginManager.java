package com.teratech.isis.config;

import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresource.ClassLoaderTemplateResource;
import org.thymeleaf.templateresource.ITemplateResource;

import javax.annotation.PostConstruct;
import java.util.Map;

@Configuration
public class ThymeleafPluginManager {

    private final SpringTemplateEngine templateEngine;
    private final PluginManager pluginManager;

    public ThymeleafPluginManager(SpringTemplateEngine templateEngine, PluginManager pluginManager) {
        this.templateEngine = templateEngine;
        this.pluginManager = pluginManager;
        System.out.println("[Core-UI] Initialisation Beans.");
    }

    @Bean
    public boolean configurePluginTemplateResolver() {
        System.out.println("[Core-UI] Inside configurePluginTemplateResolver.");
        // Création d'un résolveur qui cherche dans les ClassLoaders
        Pf4jPluginTemplateResolver pluginResolver = new Pf4jPluginTemplateResolver(pluginManager);

        // Toutes les vues de plugins devront être stockées dans un dossier "templates/plugins/"
        pluginResolver.setPrefix("templates/");
        pluginResolver.setSuffix(".html");
        pluginResolver.setTemplateMode("HTML");
        pluginResolver.setCharacterEncoding("UTF-8");

        // Ordre de priorité : on vérifie d'abord le Core,
        // si non trouvé, on bascule sur ce résolveur (ordre 2)
        pluginResolver.setOrder(templateEngine.getTemplateResolvers().size() + 1);
        pluginResolver.setCheckExistence(true);

        // Injection du nouveau résolveur dans le moteur Thymeleaf central
        templateEngine.addTemplateResolver(pluginResolver);
        System.out.println("[Core-UI] Moteur Thymeleaf configuré pour accepter les templates des plugins.");
        return true;
    }

    private static class Pf4jPluginTemplateResolver extends AbstractConfigurableTemplateResolver {

        private final PluginManager pluginManager;

        private Pf4jPluginTemplateResolver(PluginManager pluginManager) {
            this.pluginManager = pluginManager;
        }

        /**
         * @param configuration
         * @param ownerTemplate
         * @param template
         * @param resourceName
         * @param characterEncoding
         * @param templateResolutionAttributes
         * @return
         */
        @Override
        protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate, String template, String resourceName, String characterEncoding, Map<String, Object> templateResolutionAttributes) {
            // Exemple de 'resourceName' reçu : "templates/plugins/welcome/dashboard.html"
            System.out.println("[Thymeleaf Démo] Demande de ressource reçue : " + resourceName);
            // On va extraire dynamiquement l'ID du plugin depuis le chemin de la vue !
            if (resourceName.startsWith("templates/plugins/")) {
                String remainingPath = resourceName.substring("templates/plugins/".length());
                int firstSlash = remainingPath.indexOf('/');
                System.out.println("[Thymeleaf Démo] remainingPath : " + remainingPath);
                if (firstSlash != -1) {
                    // On récupère le premier dossier après "plugins/" -> c'est l'ID du plugin !
                    String pluginId = remainingPath.substring(0, firstSlash);
                    System.out.println("[Thymeleaf Démo] pluginId : " + pluginId);
                    // On demande à PF4J le wrapper du plugin en question
                    PluginWrapper pluginWrapper = pluginManager.getPlugin(pluginId);

                    if (pluginWrapper != null) {
                        // CRUCIAL : On force Thymeleaf à charger la ressource en utilisant
                        // le ClassLoader dédié de ce plugin précis !
                        return new ClassLoaderTemplateResource(
                                pluginWrapper.getPluginClassLoader(),
                                resourceName,
                                characterEncoding
                        );
                    }
                }
            }
            return null; // Laisse la main aux autres résolveurs si ce n'est pas une vue de plugin
        }
    }
}
