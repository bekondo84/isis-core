package com.teratech.isis.controller;

import com.teratech.ModelServiceException;
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
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/plugins")
public class PluginController {

    @Autowired
    private PluginService pluginService;
    @Autowired
    private DefaultAction defaultAction;


    @PostMapping
    public ResponseEntity<List<PluginModel>> getPlugins(@RequestBody ActionContextData context) throws ParseException, ClassNotFoundException, IllegalAccessException {
        context =  defaultAction.getItems(context);
        return ResponseEntity.ok((List<PluginModel>) context.get(ApplicationConstans.Actions.DATA));
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refresh() throws ModelServiceException, JAXBException, NoSuchFieldException, IllegalAccessException, InstantiationException {
       return ResponseEntity.ok(pluginService.refresh());
    }

    @PostMapping("/initialize")
    public ResponseEntity<String> initialize() throws ModelServiceException, JAXBException, IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        return ResponseEntity.ok(pluginService.initialize());
    }

    @PostMapping ("/install")
    public ResponseEntity<Boolean> sayHello(@RequestParam String plugin, @RequestParam(required = false) String version) throws IOException, JAXBException, ModelServiceException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        return ResponseEntity.ok(pluginService.install(plugin, version));
    }

    @GetMapping
    public ResponseEntity<List<PluginModel>> getAllPlugins(@RequestParam int start, @RequestParam int max) throws IllegalAccessException {
        return ResponseEntity.ok(pluginService.getPlugins(start, max));
    }
}
