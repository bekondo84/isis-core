package com.teratech.model.cms;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "cms_action")
public class ActionModel extends AbstractItem {

    @Id
    private String code ;
    private String descrip;
    private String bean;
   // private String method;
    //@Enumerated(EnumType.STRING)
    //private ActionType type;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id"),
            @JoinColumn(name = "plugin_version", referencedColumnName = "version")
    })
    private PluginModel plugin;

    public ActionModel() {
    }

    public ActionModel(String code) {
        this.code = code;
    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public void setPlugin(PluginModel plugin) {
        this.plugin = plugin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionModel that = (ActionModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return code;
    }
}
