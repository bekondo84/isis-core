package com.teratech.model.cms;

import com.teratech.annotations.Nullable;
import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

@Entity
@Table(name = "cms_dashboard")
public class DashboardModel extends AbstractItem {

    @Id
    protected String code;
    @Column(nullable = false, name = "descrip")
    protected String description;
    @Column(nullable = false)
    protected String template;
    protected Boolean enabled = true;


    @Nullable(value = false)
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id", nullable = false),
            @JoinColumn(name = "version_version", referencedColumnName = "version", nullable = false),
    })
    protected PluginModel plugin;

    public DashboardModel() {
    }

    public DashboardModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public void setPlugin(PluginModel plugin) {
        this.plugin = plugin;
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
