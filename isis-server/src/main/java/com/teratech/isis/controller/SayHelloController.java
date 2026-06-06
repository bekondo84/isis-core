package com.teratech.isis.controller;

import com.teratech.isis.services.PluginService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api")
public class SayHelloController {

    @Autowired
    private PluginService pluginService;

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> sayHello(@PathVariable String name) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, JAXBException, ClassNotFoundException {
        String response = (String) pluginService.execute("admin-plugin", "helloService", "sayHello", name);
        return ResponseEntity.ok(response);
    }
}
