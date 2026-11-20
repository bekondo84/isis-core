package com.teratech.isis.converter;

import com.teratech.beans.UiThemeSpecData;
import com.teratech.convertor.Convertor;
import com.teratech.model.settings.UiThemSpec;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UiThemeSpecConvertor implements Convertor<UiThemSpec, UiThemeSpecData> {

    private final Map<String, String> erpTemplate = new HashMap<>() {{
        put("1", "NAV_PLUGIN_001");put("2", "NAV_PLUGIN_002");put("3", "NAV_PLUGIN_003");
    }};
    private final Map<String, String> accentColor = new HashMap<>() {{
       put("1", "purple");put("2", "blue");put("3", "emerald");put("4", "indigo");put("5", "amber");put("6", "rose");put("7", "slate");
    }};
    private final Map<String, String> themeMode = new HashMap<>() {{
        put("1", "system");put("2", "light");put("3", "dark");
    }};
    private final Map<String, String> sidebarStyle = new HashMap<>() {{
        put("1", "default");put("2", "dark");put("3", "light");put("4", "brand");put("5", "purple");put("6", "blue");
        put("7", "emerald");put("8", "indigo");put("9", "amber");put("10", "rose");put("11", "slate");
    }};
    private final Map<String, String> topbarStyle = new HashMap<>() {{
        put("1", "default");put("2", "dark");put("3", "light");put("4", "brand");put("5", "purple");put("6", "blue");
        put("7", "emerald");put("8", "indigo");put("9", "amber");put("10", "rose");put("11", "slate");
    }};
    //5:;6:;7:;8:;9:;10:;11:

    @Override
    public UiThemeSpecData convert(UiThemSpec source) {
        UiThemeSpecData target = new UiThemeSpecData();
         target.setTopbarStyle(topbarStyle.get(source.getTopbarStyle()));
         target.setAccentColor(accentColor.get(source.getAccentColor()));
         target.setThemeMode(themeMode.get(source.getThemeMode()));
         target.setSidebarStyle(sidebarStyle.get(source.getSidebarStyle()));
         target.setTopbarStyle(topbarStyle.get(source.getTopbarStyle()));
         target.setSidebarCollapsed(source.getSidebarCollapsed());
         target.setErpTemplate(erpTemplate.get(source.getErpTemplate()));
         //target.setName(source.getName());
         //target.setSlogan(source.getSlogan());
        return target;
    }
}
