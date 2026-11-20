package com.teratech.isis.controller;

import com.teratech.beans.UiThemeSpecData;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.isis.converter.UiThemeSpecConvertor;
import com.teratech.isis.popultor.UserUiThemeSpecPopulator;
import com.teratech.model.security.UserModel;
import com.teratech.model.settings.GlobalUiThemeSpecModel;
import com.teratech.model.settings.SettingsModel;
import com.teratech.model.settings.UiThemSpec;
import com.teratech.model.settings.UserUiThemeSpecModel;
import com.teratech.utils.ApplicationConstans;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(ApplicationConstans.API.API_PREFIX+"/system")
public class SystemController {

    private final FlexibleSearch flexibleSearch;
    private final UiThemeSpecConvertor convertor;
    private final UserUiThemeSpecPopulator userUiThemeSpecPopulator;
    private final PersistenceManager persistenceManager;
    private final TransactionTemplate transactionTemplate;

    public SystemController(FlexibleSearch flexibleSearch, UiThemeSpecConvertor convertor, UserUiThemeSpecPopulator userUiThemeSpecPopulator, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate) {
        this.flexibleSearch = flexibleSearch;
        this.convertor = convertor;
        this.userUiThemeSpecPopulator = userUiThemeSpecPopulator;
        this.persistenceManager = persistenceManager;
        this.transactionTemplate = transactionTemplate;
    }

    @CrossOrigin("*")
    @GetMapping("/status")
    ResponseEntity<Boolean> getSystemStatus() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/user/preferences")
    ResponseEntity<Void> setUserPreferences(@RequestBody UiThemeSpecData uiTheme) throws Exception{
        final String username = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        final UserModel compte = flexibleSearch.find(new UserModel(username));

        try {
            transactionTemplate.execute(status -> {
                try {
                    UserUiThemeSpecModel userUiTheme = flexibleSearch.find(new UserUiThemeSpecModel(username));

                    if (Objects.isNull(userUiTheme)) {
                        userUiTheme = new UserUiThemeSpecModel(username);
                    }
                    if (Objects.nonNull(compte) && Objects.nonNull(compte.getBusiness())) {
                        userUiTheme.setBusinessid(compte.getBusiness().getCode());
                    }
                    userUiThemeSpecPopulator.populate(uiTheme, userUiTheme);

                    persistenceManager.save(userUiTheme);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                return status;
            });
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
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
