package com.teratech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ApplicationContext context;


    @GetMapping
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello World ! Cet endpoint vient d'un plugin PF4J chargé dynamiquement !");
    }
}
