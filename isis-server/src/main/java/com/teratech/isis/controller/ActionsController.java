package com.teratech.isis.controller;

import com.teratech.actions.ActionService;
import com.teratech.dao.FlexibleSearch;
import com.teratech.exceptions.ApplicationException;
import com.teratech.extensions.ActionExtension;
import com.teratech.metadata.ActionContextData;
import com.teratech.metadata.DashboardData;
import com.teratech.metadata.MetaData;
import com.teratech.model.cms.*;
import com.teratech.services.DashboardDataService;
import com.teratech.services.MetaDataService;
import com.teratech.utils.ApplicationConstans;
import com.teratech.utils.ApplicationConstans.Actions;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/actions")
public class ActionsController {
    public final static Logger LOGGER = LoggerFactory.getLogger(ActionsController.class.getName());

    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private MetaDataService metaDataService;
    @Autowired
    private ApplicationContext applicationContext;
   @Autowired
    private PluginManager pluginManager;
    @Autowired
   private DashboardDataService dashboardDataService;

    /**
     * Get MetaData for entity associate to navigation node
     * @param name
     * @param principal
     * @return
     */
    @CrossOrigin("*")
      @GetMapping("/navigation/meta/{name}")
      public ResponseEntity<MetaData>  processNavigationMenu(@PathVariable final String name, final Principal principal) throws Exception {

                final MenuItemModel menuItem = (MenuItemModel) flexibleSearch.find(new MenuItemModel(name));

                if (Objects.isNull(menuItem))
                    throw new IllegalArgumentException(String.format("No Navigation node found with name %s", name));
                return ResponseEntity.ok(metaDataService.buildMetaDataFrom(menuItem));

      }

      @CrossOrigin("*")
      @GetMapping("/navigation/dashboard/{name}")
      public ResponseEntity<DashboardData> processNavigationDashboard(@PathVariable final String name, final Principal principal) throws Exception {
          final MenuItemModel menuItem = flexibleSearch.find(new MenuItemModel(name));

          if (Objects.isNull(menuItem))
              throw new IllegalArgumentException(String.format("No Navigation node found with name %s", name));
          //Find Dashboard associate
          final DashboardModel dashboard = flexibleSearch.find(new DashboardModel(menuItem.getType()));
          if (Objects.isNull(dashboard))
              throw new IllegalArgumentException(String.format("No Dashboard record found with name %s", menuItem.getType()));
          return ResponseEntity.ok(dashboardDataService.buildDashboardData(dashboard));
      }


    /**
     * Get meta data for entity base on it name, if custom action is provided then use this action to get
     * @param name
     * @param principal
     * @return
     */
    @CrossOrigin("*")
    @GetMapping("/entity/meta/{name}")
      public ResponseEntity<MetaData> getMetaForTypeCode(@PathVariable final String name, final Principal principal) throws Exception {
          final MetaTypeModel metaType = (MetaTypeModel) flexibleSearch.find(new MetaTypeModel(name));

          if (Objects.isNull(metaType)) {
              throw new IllegalArgumentException(String.format("No meta type found with name %s", name));
          }
          return ResponseEntity.ok(metaDataService.buildMetaDataFrom(metaType));
      }

      @CrossOrigin("*")
      @GetMapping("/dashboard/{code}")
      public  ResponseEntity<DashboardData> getDashboardByCode(String code, Principal principal) throws Exception {
          final DashboardModel dashboard = (DashboardModel) flexibleSearch.find(new DashboardModel(code));

          if (Objects.isNull(dashboard)) {
              throw new IllegalArgumentException(String.format("No dashboard found with code %s", code));
          }

          return ResponseEntity.ok(dashboardDataService.buildDashboardData(dashboard));
      }


    /**
     * Execute Post method action, when the value is defautAction then use the defaut action
     * @param context
     * @param action
     * @param principal
     * @return
     */
      @CrossOrigin("*")
      @PostMapping("execute/{action}/{method}")
      public ResponseEntity<ActionContextData> executePostAction(@RequestBody ActionContextData context, @PathVariable final String action, @PathVariable final String method, final Principal principal) throws ApplicationException {
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
    @CrossOrigin("*")
    @PutMapping("execute/{action}/{method}")
    public ResponseEntity<ActionContextData> executePutAction(@RequestBody ActionContextData context, @PathVariable final String action, @PathVariable String method, final Principal principal) throws ApplicationException {
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
    @CrossOrigin("*")
    @DeleteMapping("execute/{action}/{method}")
    public ResponseEntity<ActionContextData> executeDeleteAction(@RequestBody ActionContextData context, @PathVariable final String action, @PathVariable String method, final Principal principal) throws ApplicationException {
        return executeAction(context, action, method, ActionType.DELETE);
    }

    @CrossOrigin("*")
    @GetMapping("execute/{action}/{method}")
    public ResponseEntity<ActionContextData> executeAction(@ModelAttribute Map<String, String> context, @PathVariable String action, @PathVariable String method) throws Exception {
           ActionContextData appcontext = new ActionContextData();
           appcontext.put(Actions.TYPECODE, context.get(Actions.TYPECODE));
           appcontext.put(Actions.TYPE, context.get(Actions.TYPE));
           appcontext.put(Actions.PLUGIN, context.get(Actions.PLUGIN));
           appcontext.put(Actions.PAGESIZE, context.get(Actions.PAGESIZE));
           appcontext.put(Actions.NBREOFITEMS, context.get(Actions.NBREOFITEMS));
           final Map<String, String> data = new HashMap<>();

           if (Objects.nonNull(context)) {
               for (String key : context.keySet()) {
                   if (!Arrays.asList(Actions.TYPECODE, Actions.TYPE, Actions.NBREOFITEMS, Actions.PLUGIN, Actions.PAGESIZE).contains(context.get(key))) {
                       data.put(key, context.get(key));
                   }
               }
           }
           appcontext.put(Actions.DATA, data);

          return executeAction(appcontext, action, method, ActionType.GET);
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
    private ResponseEntity<ActionContextData> executeAction(ActionContextData context, String actionId, String method, ActionType type) throws ApplicationException {

        try {
            final ActionModel action = (ActionModel) flexibleSearch.find(new ActionModel(actionId));
            //Check if the action exists
            if (Objects.isNull(action))
                throw new ApplicationException("500", String.format("No action found with ID %s", actionId));

            //Case where action it is a global action
            if (Objects.isNull(action.getPlugin())) {
                Object bean = applicationContext.getBean(action.getBean());
                //Check that bean implement ActionService interface
                if (!ActionService.class.isAssignableFrom(bean.getClass()))
                    throw new IllegalStateException(String.format("Bean with name %s don't implement Service interface. Please make sure it implement ActionService interface", action.getBean()));

                return ResponseEntity.ok(((ActionService) bean).invoke(action, method, type, context));
            }
            //The Action is link to specific plugin
            List actionExtensions = pluginManager.getExtensions(ActionExtension.class, action.getPlugin().getId());

            if (CollectionUtils.isEmpty(actionExtensions))
                throw new IllegalStateException(String.format("Plugin Configuration Error : No ActionExtension implementation found for plugin %s", action.getPlugin().getId()));

            ActionExtension actionExtension = (ActionExtension) actionExtensions.get(0);

            return ResponseEntity.ok(actionExtension.invoke(context, action, method, type));
        } catch (ApplicationException e) {
            throw e;
        }catch (Exception e) {
            Throwable cause = e;
            if (e instanceof InvocationTargetException && e.getCause() != null) {
                cause = e.getCause();
            }
            String message = cause.getMessage();

            throw new ApplicationException("500", message, e);
        }
    }

}