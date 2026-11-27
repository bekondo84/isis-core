package com.teratech.model;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adm_plugin_state")
public class PluginStateModel extends AbstractItem {

    public static final PluginStateModel AVAILABLE = new PluginStateModel("AVAILABLE");
    public static final PluginStateModel UNINSTALL = new PluginStateModel("UNINSTALL");
    public static final PluginStateModel INSTALL = new PluginStateModel("INSTALL");

    @Id
    private String code;
    private String description;

    public PluginStateModel() {
    }

    public PluginStateModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public PluginStateModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PluginStateModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public Object getPk() {
        return code;
    }

    @Override
    public void toStringValue() {
         stringValue = description;
    }
}
