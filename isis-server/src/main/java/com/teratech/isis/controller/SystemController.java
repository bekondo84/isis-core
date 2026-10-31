package com.teratech.isis.controller;

import com.teratech.utils.ApplicationConstans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/system")
public class SystemController {

    @GetMapping("/isrunning")
    ResponseEntity<Boolean> isRunning() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
