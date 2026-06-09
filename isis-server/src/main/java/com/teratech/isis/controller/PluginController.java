package com.teratech.isis.controller;

import com.teratech.services.PluginService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/server")
public class PluginController {

    @Autowired
    private PluginService pluginService;

    @PostMapping("/plugins/initialize")
    public ResponseEntity<String> initialize() throws JAXBException, IllegalStateException {

        return ResponseEntity.ok(pluginService.initialize());
    }

    @PostMapping ("/plugins/install")
    public ResponseEntity<Boolean> sayHello(@RequestParam String plugin, @RequestParam(required = false) String version) throws IOException {
        return ResponseEntity.ok(pluginService.install(plugin, version));
    }
}
