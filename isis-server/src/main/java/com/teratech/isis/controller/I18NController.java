package com.teratech.isis.controller;

import com.teratech.services.I18NService;
import com.teratech.utils.ApplicationConstans;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/i18n")
public class I18NController {

    private final I18NService i18NService;

    public I18NController(I18NService i18NService) {
        this.i18NService = i18NService;
    }


    @GetMapping("/message")
    public ResponseEntity<String> translate(@RequestParam(name = "key", required = true)String key, @RequestParam(name = "lang")String lang){
        return ResponseEntity.ok(i18NService.getMessage(key));
    }
}
