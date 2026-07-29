package com.teratech.isis.controller;

import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.isis.actions.DefaultAction;
import com.teratech.metadata.ActionContextData;
import com.teratech.model.PluginModel;
import com.teratech.services.PluginService;
import com.teratech.utils.ApplicationConstans;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/plugins")
public class PluginController {

    @Autowired
    private PluginService pluginService;
    @Autowired
    private DefaultAction defaultAction;


    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<List<PluginModel>> getPlugins(@RequestBody ActionContextData context) throws ApplicationException {
       try {
           context = defaultAction.getItems(context);
           return ResponseEntity.ok((List<PluginModel>) context.get(ApplicationConstans.Actions.DATA));
       } catch (Exception e) {
           throw new ApplicationException(e);
       }
    }

    @CrossOrigin("*")
    @PostMapping("/refresh")
    public ResponseEntity<String> refresh() throws ApplicationException {
      try {
          return ResponseEntity.ok(pluginService.refresh());
      } catch (Exception e) {
          throw new ApplicationException(e);
      }
    }

    @CrossOrigin("*")
    @PostMapping("/initialize")
    public ResponseEntity<String> initialize() throws ApplicationException {
       try {
           return ResponseEntity.ok(pluginService.initialize());
       } catch (Exception e) {
           throw new ApplicationException(e);
       }
    }

    @CrossOrigin("*")
    @PostMapping ("/install")
    public ResponseEntity<Boolean> sayHello(@RequestParam String plugin, @RequestParam(required = false) String version) throws ApplicationException {
        return ResponseEntity.ok(pluginService.install(plugin));
    }

    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<List<PluginModel>> getAllPlugins(@RequestParam int start, @RequestParam int max) throws ApplicationException {

        try {
            return ResponseEntity.ok(pluginService.getPlugins(start, max));
        } catch (Exception e) {
            throw new ApplicationException(e);
        }

    }
}
