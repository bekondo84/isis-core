package com.teratech.isis.utils;

import com.teratech.annotation.Open;
import org.pf4j.PluginWrapper;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Objects;

public class Utils {

    public static RequestMappingInfo getMappingInfo(Method method, Class<?> beanType, RequestMappingHandlerMapping mapping, PluginWrapper wrapper) {
        // 1. On cherche le @RequestMapping sur la MÉTHODE (ex: @GetMapping("/hello"))
        RequestMapping methodMapping = AnnotatedElementUtils.findMergedAnnotation(method, RequestMapping.class);
        if (methodMapping == null) return null;

        // 2. On cherche le @RequestMapping sur la CLASSE (ex: @RequestMapping("/api/v1"))
        RequestMapping classMapping = AnnotatedElementUtils.findMergedAnnotation(beanType, RequestMapping.class);

        //3. On recherche le @Open sur la classe : ceci permet de determiner si l'api est public ou private
        Open classOpen = AnnotatedElementUtils.findMergedAnnotation(beanType, Open.class);

        // 4. Configuration de base de Spring pour l'objet de mapping
        RequestMappingInfo.Builder builder = RequestMappingInfo
                .paths(methodMapping.path().length > 0 ? methodMapping.path() : methodMapping.value())
                .methods(methodMapping.method())
                .options(mapping.getBuilderConfiguration());

        RequestMappingInfo finalInfo =  builder.build();

        // 5. S'il y a un préfixe sur la classe, on le fusionne de force !
        if (classMapping != null) {
            String[] classPaths = classMapping.path().length > 0 ? classMapping.path() : classMapping.value();
            if (classPaths.length > 0) {
                // Cette méthode native de Spring combine proprement les patterns (gère les "/" manquants)
                RequestMappingInfo classMappingInfo = RequestMappingInfo.paths(classPaths).build();
                finalInfo = classMappingInfo.combine(builder.build());
            }
        }

        // 6. CRUCIAL : Injection du Plugin ID comme préfixe global de la route
        // On s'assure que le préfixe ressemble à "/pluginId"
          String prefix = "" ;
          if (isRestController(beanType)) {
               prefix = "/api" ;
              if (Objects.nonNull(classOpen)) {
                  prefix = "/api/public";
              }
              prefix+= "/"+wrapper.getPluginId().toLowerCase().trim();
          } else {
              prefix = "web";
              if (Objects.nonNull(classOpen)) {
                  prefix = "/web/public";
              }
              prefix +="/"+wrapper.getPluginId().toLowerCase().trim();
          }
        //isRestController(beanType)  ? "/api/" +  : ;

        //7. Position public si la classe est annoté @Open

        finalInfo = RequestMappingInfo.paths(prefix)
                .options(mapping.getBuilderConfiguration())
                .build()
                .combine(finalInfo);

        return finalInfo;
        //return builder.build();
    }

    /**
     * Check if BeanType is a rest controller
     * @param beanType
     * @return
     */
    private static boolean isRestController (Class<?> beanType) {
        return Objects.nonNull(beanType) && beanType.isAnnotationPresent(RestController.class);
    }
}
