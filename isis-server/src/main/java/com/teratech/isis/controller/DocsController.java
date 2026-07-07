package com.teratech.isis.controller;

import com.teratech.beans.DocData;
import com.teratech.utils.ApplicationConstans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/docs")
public class DocsController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;



    @GetMapping
    public ResponseEntity<List<DocData>> getDocs() {
        final List<DocData> docs = new ArrayList<>();

       // requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
              // System.out.println(String.format("%s ", key));
        //});

        return ResponseEntity.ok(docs);
    }
}
