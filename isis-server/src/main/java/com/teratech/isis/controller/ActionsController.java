package com.teratech.isis.controller;

import com.teratech.dao.FlexibleSearch;
import com.teratech.metadata.ActionContextData;
import com.teratech.metadata.MetaData;
import com.teratech.model.cms.MenuItemModel;
import com.teratech.model.cms.MetaTypeModel;
import com.teratech.services.MetaDataService;
import com.teratech.utils.ApplicationConstans;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/actions")
public class ActionsController {

    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private MetaDataService metaDataService;

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

              final MetaTypeModel metaType = (MetaTypeModel) flexibleSearch.find(new MetaTypeModel(menuItem.getType()));

              return  ResponseEntity.ok(metaDataService.buildMetaDataFrom(menuItem));
      }


    /**
     * Get meta data for entity base on it name, if custom action is provided then use this action to get
     * @param name
     * @param principal
     * @return
     */
      @GetMapping("/entity/meta/{name}")
      public ResponseEntity<MetaData> getMetaForTypeCode(@PathVariable final String name, final Principal principal) {

          return ResponseEntity.ok(null);
      }

    /**
     * Execute Get method action when the value is defaultAction then use defautAction
     * @param context
     * @param action
     * @param principal
     * @return
     */
      @RequestMapping("execute/{action}")
    public ResponseEntity<ActionContextData> executeGetAction(@RequestBody ActionContextData context, @PathVariable final String action, final Principal principal) {

        return ResponseEntity.ok(null);
    }
    /**
     * Execute Post method action, when the value is defautAction then use the defaut action
     * @param context
     * @param action
     * @param principal
     * @return
     */
      @PostMapping("execute/{action}")
      public ResponseEntity<ActionContextData> executePostAction(@RequestBody ActionContextData context, @PathVariable final String action, final Principal principal) {

          return ResponseEntity.ok(null);
      }

    /**
     * Execute Put method action, when the value is defautAction then use the defaut action
     * @param context
     * @param action
     * @param principal
     * @return
     */
    @PutMapping("execute/{action}")
    public ResponseEntity<ActionContextData> executePutAction(@RequestBody ActionContextData context, @PathVariable final String action, final Principal principal) {

        return ResponseEntity.ok(null);
    }

    /**
     * Execute Delete method action, when the value is defautAction then use the defaut action
     * @param context
     * @param action
     * @param principal
     * @return
     */
    @DeleteMapping("execute/{action}")
    public ResponseEntity<ActionContextData> executeDeleteAction(@RequestBody ActionContextData context, @PathVariable final String action, final Principal principal) {

        return ResponseEntity.ok(null);
    }
}
