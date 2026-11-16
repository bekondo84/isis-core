package com.teratech.isis.controller;

import com.teratech.dao.FlexibleSearch;
import com.teratech.model.settings.SettingsModel;
import com.teratech.utils.ApplicationConstans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/system")
public class SystemController {

    private final FlexibleSearch flexibleSearch;

    public SystemController(FlexibleSearch flexibleSearch) {
        this.flexibleSearch = flexibleSearch;
    }

    @CrossOrigin("*")
    @GetMapping("/status")
    ResponseEntity<Boolean> getSystemStatus() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/general/settings")
    ResponseEntity<Map<String, String>> getGeneralSettings() throws Exception{
        final Map<String, String> generalSettings = new HashMap<>();
        SettingsModel settings = flexibleSearch.find(new SettingsModel("ERP_NAME"));
        if (Objects.nonNull(settings)) {
            generalSettings.put(settings.getKey(), settings.getValue());
        }
        settings = flexibleSearch.find(new SettingsModel("ERP_SIGLE"));
        if (Objects.nonNull(settings)) {
            generalSettings.put(settings.getKey(), settings.getValue());
        }
        settings = flexibleSearch.find(new SettingsModel("ERP_SLOGAN"));
        if (Objects.nonNull(settings)) {
            generalSettings.put(settings.getKey(), settings.getValue());
        }
        settings = flexibleSearch.find(new SettingsModel("ERP_TEMPLATE"));
        if (Objects.nonNull(settings)) {
            generalSettings.put(settings.getKey(), settings.getValue());
        }
        settings = flexibleSearch.find(new SettingsModel("ERP_THEME"));
        if (Objects.nonNull(settings)) {
            generalSettings.put(settings.getKey(), settings.getValue());
        }
        settings = flexibleSearch.find(new SettingsModel("ERP_ACCENT_COLOR"));
        if (Objects.nonNull(settings)) {
            generalSettings.put(settings.getKey(), settings.getValue());
        }
        return ResponseEntity.ok(generalSettings);
    }

}
