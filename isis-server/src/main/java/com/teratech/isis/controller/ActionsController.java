package com.teratech.isis.controller;

import com.teratech.actions.ActionService;
import com.teratech.dao.FlexibleSearch;
import com.teratech.extensions.ActionExtension;
import com.teratech.metadata.ActionContextData;
import com.teratech.metadata.MetaData;
import com.teratech.model.cms.ActionModel;
import com.teratech.model.cms.ActionType;
import com.teratech.model.cms.MenuItemModel;
import com.teratech.model.cms.MetaTypeModel;
import com.teratech.services.MetaDataService;
import com.teratech.utils.ApplicationConstans;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/actions")
public class ActionsController {

    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private MetaDataService metaDataService;
    @Autowired
    private ApplicationContext applicationContext;
   @Autowired
    private PluginManager pluginManager;

    /**
     * Get MetaData for entity associate to navigation node
     * @param name
     * @param principal
     * @return
     */
      @GetMapping("/navigation/meta/{name}")
      public ResponseEntity<MetaData>  processNavigationMenu(@PathVariable final String name, final Principal principal) throws IllegalAccessException, JAXBException, ClassNotFoundException, NoSuchFieldException, InstantiationException {

              final MenuItemModel menuItem = (MenuItemModel) flexibleSearch.find(new MenuItemModel(name));

              if (Objects.isNull(menuItem))
                  throw new IllegalArgumentException(String.format("No Navigation node found with name %s", name));
              return  ResponseEntity.ok(metaDataService.buildMetaDataFrom(menuItem));
      }


    /**
     * Get meta data for entity base on it name, if custom action is provided then use this action to get
     * @param name
     * @param principal
     * @return
     */
      @GetMapping("/entity/meta/{name}")
      public ResponseEntity<MetaData> getMetaForTypeCode(@PathVariable final String name, final Principal principal) throws NoSuchFieldException, IllegalAccessException, InstantiationException, JAXBException, ClassNotFoundException {
          final MetaTypeModel metaType = (MetaTypeModel) flexibleSearch.find(new MetaTypeModel(name));
          return ResponseEntity.ok(metaDataService.buildMetaDataFrom(metaType));
      }


    /**
     * Execute Post method action, when the value is defautAction then use the defaut action
     * @param context
     * @param action
     * @param principal
     * @return
     */
      @PostMapping("execute/{action}/{method}")
      public ResponseEntity<ActionContextData> executePostAction(@RequestBody ActionContextData context, @PathVariable final String action, @PathVariable final String method, final Principal principal) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
          return executeAction(context, action, method, ActionType.POST);
      }

    /**
     * Execute Put method action, when the value is defautAction then use the defaut action
     * @param context
     * @param action
     * @param method
     * @param principal
     * @return
     */
    @PutMapping("execute/{action}/{method}")
    public ResponseEntity<ActionContextData> executePutAction(@RequestBody ActionContextData context, @PathVariable final String action, @PathVariable String method, final Principal principal) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return executeAction(context, action, method, ActionType.PUT);
    }

    /**
     * Execute Delete method action, when the value is defautAction then use the defaut action
     * @param context
     * @param action
     * @param method
     * @param principal
     * @return
     */
    @DeleteMapping("execute/{action}/{method}")
    public ResponseEntity<ActionContextData> executeDeleteAction(@RequestBody ActionContextData context, @PathVariable final String action, @PathVariable String method, final Principal principal) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return executeAction(context, action, method, ActionType.DELETE);
    }

    /**
     * Invoke Action method if exists
     * @param context
     * @param actionId
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     * @throws InvocationTargetException
     */
    private ResponseEntity<ActionContextData> executeAction(ActionContextData context, String actionId, String method, ActionType type) throws IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException {
        final ActionModel action = (ActionModel) flexibleSearch.find(new ActionModel(actionId));
        //Check if the action exists
        assert Objects.nonNull(action) : String.format("No action found with ID %s", actionId);

        //Case where action it is a global action
        if (Objects.isNull(action.getPlugin())) {
            Object bean = applicationContext.getBean(action.getBean());
            //Check that bean implement ActionService interface
            assert ActionService.class.isAssignableFrom(bean.getClass()) : String.format("Bean with name %s don't implement Service interface. Please make sure it implement ActionService interface", action.getBean());

            return ResponseEntity.ok(((ActionService) bean).invoke(action, method, type, context));
        }
        //The Action is link to specific plugin
        List actionExtensions = pluginManager.getExtensions(ActionExtension.class, action.getPlugin().getId());
        assert !CollectionUtils.isEmpty(actionExtensions) : String.format("Plugin Gonfiguration : No ActionExtension implementation found for plugin %s", action.getPlugin().getId());
        ActionExtension actionExtension = (ActionExtension) actionExtensions.get(0);

        return ResponseEntity.ok(actionExtension.invoke(context, action, method, type));
    }

}
