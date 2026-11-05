package com.teratech.isis.controller;

import com.teratech.dao.FlexibleSearch;
import com.teratech.model.cms.MetaTypeModel;
import com.teratech.services.I18NService;
import com.teratech.utils.ApplicationConstans;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/i18n")
public class I18NController {
    private static final Logger LOG = LoggerFactory.getLogger(I18NController.class);
    private final I18NService i18NService;
    private final FlexibleSearch flexibleSearch;

    public I18NController(I18NService i18NService, FlexibleSearch flexibleSearch) {
        this.i18NService = i18NService;
        this.flexibleSearch = flexibleSearch;
    }


    @GetMapping("/message")
    public ResponseEntity<String> translate(@RequestParam(name = "key", required = true)String key, @RequestParam(name = "lang")String lang){
        return ResponseEntity.ok(i18NService.getMessage(key));
    }

    @GetMapping("/values")
    public ResponseEntity<Map<String, String>> getComboxValues(@RequestParam(name = "typecode", required = true)String typecode, @RequestParam(name = "field")String field, @RequestParam(name = "lang", required = false)String lang) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Map<String, String> comboObject = new HashMap<>();
        MetaTypeModel metaType = flexibleSearch.find(new MetaTypeModel(typecode));
        String pluginId = null;
        if (metaType != null  && metaType.getPlugin() != null) {
            pluginId = metaType.getPlugin().getId();
        }
        StringBuffer buffer = new StringBuffer(typecode);
        buffer.append(".").append(field).append(".values");
        String value = i18NService.getMessage(pluginId, buffer.toString());
        if (StringUtils.isNotBlank(value) && value.matches("^\\d+:[^;]+(?:;\\d+:[^;]+)*$")) {
            String[] values = value.split(";");
            for (String v : values) {
                String[] keyValue = v.split(":");
                comboObject.put(keyValue[0], keyValue[1]);
            }
        }
        return ResponseEntity.ok(comboObject);
    }
}
