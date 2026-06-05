package com.teratech.isis.config;

import com.teratech.extensions.ControllerExtensionPoint;
import com.teratech.isis.utils.Utils;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.List;

@Component
public class RestPluginManager {

    private final PluginManager pluginManager;
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;


    @Autowired
    public RestPluginManager(PluginManager pluginManager, RequestMappingHandlerMapping handlerMapping) {
        this.pluginManager = pluginManager;
        this.requestMappingHandlerMapping = handlerMapping;
    }

    public  void registerPluginControllers() throws JAXBException {
// 1. Récupérer toutes les extensions REST des plugins
       // List<RestExtensionPoint> extensions = pluginManager.getExtensions(RestExtensionPoint.class);
        List<PluginWrapper> plugins = pluginManager.getPlugins();

        for (PluginWrapper wrapper : plugins) {
            List<ControllerExtensionPoint> extensions =  pluginManager.getExtensions(ControllerExtensionPoint.class, wrapper.getPluginId());
            System.out.println("[Core-Web] Recherche de contrôleurs REST dans les plugins... Trouvé(s) : " + extensions.size()+"    "+wrapper.getPluginId());

            for (ControllerExtensionPoint extension : extensions) {
                registerExtensionController(extension, wrapper);
            }
        }

    }

    /**
     * Register controller class in the requestMappingHandlerMapping so it can expose it URL
     * @param extension
     * @throws JAXBException
     */
    private void registerExtensionController(ControllerExtensionPoint extension, PluginWrapper wrapper) throws JAXBException {
        List controllers = extension.getRestController(wrapper);
        System.out.println("-----registerExtensionController ----------------- : "+controllers.size()+" ---- "+controllers);

        for (Object controller: controllers) {
            Class<?> beanType = controller.getClass();

            // 2. Demander à Spring de scanner les méthodes d'API du contrôleur (ex: @GetMapping)
            Method[] methods = beanType.getDeclaredMethods();
            for (Method method : methods) {
                // On vérifie si la méthode possède une configuration de mapping Spring Web
                // La méthode de Spring 'getMappingForMethod' fait tout le travail de détection
                var mappingInfo = Utils.getMappingInfo(method, beanType, requestMappingHandlerMapping, wrapper);

                if (mappingInfo != null) {
                    // 3. Injection dynamique de la route dans le routeur de Spring Boot
                    requestMappingHandlerMapping.registerMapping(mappingInfo, controller, method);
                    System.out.println("[Core-Web] Route enregistrée dynamiquement : " + mappingInfo);

// LIGNE DE TEST : Affiche toutes les routes actuellement connues par le routeur de Spring
                    this.requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
                        System.out.println("[Routeur Verif] " + key + " -> " + value);
                    });
                }
            }
        }
    }
}
