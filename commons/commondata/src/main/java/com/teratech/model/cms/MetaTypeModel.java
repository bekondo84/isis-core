package com.teratech.model.cms;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cms_metatype")
public class MetaTypeModel extends AbstractItem {

    @Id
    private String code;
    @Column(name = "class_name")
    private String className;
    private Boolean concrete;
    private String descrip;
    private String template;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id"),
            @JoinColumn(name = "plugin_version", referencedColumnName = "version")
    })
    private PluginModel plugin;
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "metatype_id")
    private List<MetaFieldModel> fields = new ArrayList<>();


    public MetaTypeModel() {
    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public void setPlugin(PluginModel plugin) {
        this.plugin = plugin;
    }

    public MetaTypeModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Boolean getConcrete() {
        return concrete;
    }

    public void setConcrete(Boolean concrete) {
        this.concrete = concrete;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<MetaFieldModel> getFields() {
        return fields;
    }

    public void setFields(List<MetaFieldModel> fields) {
        this.fields = fields;
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
