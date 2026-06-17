package com.teratech.isis.controller;

import com.teratech.ModelServiceException;
import com.teratech.model.PluginModel;
import com.teratech.services.PluginService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/server")
public class PluginController {

    @Autowired
    private PluginService pluginService;

    @PostMapping("/plugins/refresh")
    public ResponseEntity<String> refresh() throws ModelServiceException, JAXBException {
       return ResponseEntity.ok(pluginService.refresh());
    }

    @PostMapping("/plugins/initialize")
    public ResponseEntity<String> initialize() throws ModelServiceException, JAXBException, IOException, IllegalAccessException {

        return ResponseEntity.ok(pluginService.initialize());
    }

    @PostMapping ("/plugins/install")
    public ResponseEntity<Boolean> sayHello(@RequestParam String plugin, @RequestParam(required = false) String version) throws IOException, JAXBException, ModelServiceException, IllegalAccessException {
        return ResponseEntity.ok(pluginService.install(plugin, version));
    }

    @GetMapping("/plugins")
    public ResponseEntity<List<PluginModel>> getAllPlugins(@RequestParam int start, @RequestParam int max) throws IllegalAccessException {
        return ResponseEntity.ok(pluginService.getPlugins(start, max));
    }
}
