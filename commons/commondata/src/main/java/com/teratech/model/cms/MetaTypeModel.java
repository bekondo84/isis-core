package com.teratech.model.cms;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
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
    private String dbtable;
    private String template;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id"),
            @JoinColumn(name = "plugin_version", referencedColumnName = "version")
    })
    private PluginModel plugin;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "metatype_id")
    private List<MetaFieldModel> fields = new ArrayList<>();


    public MetaTypeModel() {
    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public MetaTypeModel setPlugin(PluginModel plugin) {
        this.plugin = plugin;
        return this;
    }

    public MetaTypeModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public MetaTypeModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public MetaTypeModel setClassName(String className) {
        this.className = className;
        return this;
    }

    public Boolean getConcrete() {
        return concrete;
    }

    public MetaTypeModel setConcrete(Boolean concrete) {
        this.concrete = concrete;
        return this;
    }

    public String getDescrip() {
        return descrip;
    }

    public MetaTypeModel setDescrip(String descrip) {
        this.descrip = descrip;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public MetaTypeModel setTemplate(String template) {
        this.template = template;
        return this;
    }

    public String getDbtable() {
        return dbtable;
    }

    public MetaTypeModel setDbtable(String dbtable) {
        this.dbtable = dbtable;
        return this;
    }

    public List<MetaFieldModel> getFields() {
        return Collections.unmodifiableList(fields) ;
    }

    public void setFields(List<MetaFieldModel> fields) {
        this.fields = fields;
    }

    public void addField (MetaFieldModel fied) {
        this.fields.add(fied);
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

    /**
     * Build and convert the entity in String
     */
    @Override
    public void toStringValue() {
        stringValue = code;
    }
}
