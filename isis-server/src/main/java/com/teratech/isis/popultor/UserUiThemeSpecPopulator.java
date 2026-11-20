package com.teratech.isis.popultor;

import com.teratech.beans.UiThemeSpecData;
import com.teratech.model.settings.UserUiThemeSpecModel;
import com.teratech.populator.Populator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserUiThemeSpecPopulator implements Populator <UiThemeSpecData, UserUiThemeSpecModel>{

    private final List<String> erpTemplates = Arrays.asList("NAV_PLUGIN_001", "NAV_PLUGIN_002","NAV_PLUGIN_003") ;
    private final List<String> accentColors = Arrays.asList("purple", "blue", "emerald", "indigo", "rose", "slate") ;
    private final List<String> barStyles = Arrays.asList("default", "dark", "light", "brand", "purple", "blue", "emerald", "indigo", "amber", "rose", "slate") ;
    private final List<String> themes = Arrays.asList("system", "light", "dark");

    @Override
    public void populate(UiThemeSpecData source, UserUiThemeSpecModel target) throws Exception {
            target.setAccentColor(Integer.toString(accentColors.indexOf(source.getAccentColor()) + 1));
            target.setErpTemplate(Integer.toString(erpTemplates.indexOf(source.getErpTemplate()) + 1));
            target.setSidebarStyle(Integer.toString(barStyles.indexOf(source.getSidebarStyle()) + 1));
            target.setTopbarStyle(Integer.toString(barStyles.indexOf(source.getTopbarStyle()) + 1));
            target.setThemeMode(Integer.toString(themes.indexOf(source.getThemeMode()) + 1));
    }
}
