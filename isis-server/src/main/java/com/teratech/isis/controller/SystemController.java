package com.teratech.isis.controller;

import com.teratech.beans.UiThemeSpecData;
import com.teratech.dao.FlexibleSearch;
import com.teratech.isis.converter.UiThemeSpecConvertor;
import com.teratech.model.settings.GlobalUiThemeSpecModel;
import com.teratech.model.settings.SettingsModel;
import com.teratech.model.settings.UiThemSpec;
import com.teratech.model.settings.UserUiThemeSpecModel;
import com.teratech.utils.ApplicationConstans;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final UiThemeSpecConvertor convertor;

    public SystemController(FlexibleSearch flexibleSearch, UiThemeSpecConvertor convertor) {
        this.flexibleSearch = flexibleSearch;
        this.convertor = convertor;
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
        String username = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        final GlobalUiThemeSpecModel globalUiTheme = flexibleSearch.find(new GlobalUiThemeSpecModel("GLOBAL"));
        final UserUiThemeSpecModel userUiTheme = flexibleSearch.find(new UserUiThemeSpecModel(username));
        final UiThemSpec uiThemSpec = new UiThemSpec();
        //Initialize UiThemSpec with user preference
        if (Objects.nonNull(userUiTheme)) {
            uiThemSpec.setSidebarStyle(userUiTheme.getSidebarStyle());
            uiThemSpec.setTopbarStyle(userUiTheme.getTopbarStyle());
            uiThemSpec.setSidebarCollapsed(userUiTheme.getSidebarCollapsed());
            uiThemSpec.setErpTemplate(userUiTheme.getErpTemplate());
            uiThemSpec.setThemeMode(userUiTheme.getThemeMode());
            uiThemSpec.setAccentColor(userUiTheme.getAccentColor());
        }
        if (Objects.nonNull(globalUiTheme)) {
            if (StringUtils.isNotBlank(globalUiTheme.getThemeMode())) {
                uiThemSpec.setThemeMode(globalUiTheme.getThemeMode());
            }
            if (StringUtils.isNotBlank(globalUiTheme.getSidebarStyle())) {
                uiThemSpec.setSidebarStyle(globalUiTheme.getSidebarStyle());
            }
            if (StringUtils.isNotBlank(globalUiTheme.getTopbarStyle())) {
                uiThemSpec.setTopbarStyle(globalUiTheme.getTopbarStyle());
            }
            if (StringUtils.isNotBlank(globalUiTheme.getErpTemplate())) {
                uiThemSpec.setErpTemplate(globalUiTheme.getErpTemplate());
            }
            if (StringUtils.isNotBlank(globalUiTheme.getAccentColor())) {
                uiThemSpec.setAccentColor(globalUiTheme.getAccentColor());
            }
            if (StringUtils.isNotBlank(globalUiTheme.getName())) {
                generalSettings.put("ERP_NAME", globalUiTheme.getName());
            }
            if (StringUtils.isNotBlank(globalUiTheme.getSlogan())) {
                generalSettings.put("ERP_SIGLE", globalUiTheme.getSlogan());
            }
        }

        UiThemeSpecData uiThemeSpecData = convertor.convert(uiThemSpec);

        if (StringUtils.isNotBlank(uiThemeSpecData.getAccentColor())) {
            generalSettings.put("ERP_ACCENT_COLOR", uiThemeSpecData.getAccentColor());
        }
        if (StringUtils.isNotBlank(uiThemeSpecData.getThemeMode())) {
            generalSettings.put("ERP_THEME", uiThemeSpecData.getThemeMode());
        }
        if (StringUtils.isNotBlank(uiThemeSpecData.getErpTemplate())) {
            generalSettings.put("ERP_TEMPLATE", uiThemeSpecData.getErpTemplate());
        }
        if (StringUtils.isNotBlank(uiThemeSpecData.getSidebarStyle())) {
            generalSettings.put("ERP_SIDEBAR_STYLE", uiThemeSpecData.getSidebarStyle());
        }
        if (StringUtils.isNotBlank(uiThemeSpecData.getTopbarStyle())) {
            generalSettings.put("ERP_TOPBAR_STYLE", uiThemeSpecData.getTopbarStyle());
        }
        if (Objects.nonNull(uiThemeSpecData.getSidebarCollapsed())) {
            generalSettings.put("ERP_SIDEBAR_COLLAPSED", uiThemeSpecData.getSidebarCollapsed().toString());
        }
        return ResponseEntity.ok(generalSettings);
    }

}
