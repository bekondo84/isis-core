package com.teratech.isis.popultor;

import com.teratech.model.settings.GlobalUiThemeSpecModel;
import com.teratech.populator.Populator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GlobalUiThemeSpecPopulator implements Populator<GlobalUiThemeSpecModel, GlobalUiThemeSpecModel> {
    @Override
    public void populate(GlobalUiThemeSpecModel source, GlobalUiThemeSpecModel target) throws Exception {
             if (Objects.isNull(source)) {
                 return;
             }
             target.setCode(source.getCode());
             target.setAccentColor(source.getAccentColor());
             target.setErpTemplate(source.getErpTemplate());
             target.setThemeMode(source.getThemeMode());
             target.setSidebarStyle(source.getSidebarStyle());
             target.setSidebarCollapsed(source.getSidebarCollapsed());
             target.setTopbarStyle(source.getTopbarStyle());
    }
}
