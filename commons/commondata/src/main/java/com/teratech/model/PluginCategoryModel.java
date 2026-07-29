package com.teratech.model;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "adm_plugin_category")
public class PluginCategoryModel extends AbstractItem {

    @Id
    private String code;
    private String title;

    public String getCode() {
        return code;
    }

    public PluginCategoryModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PluginCategoryModel setTitle(String title) {
        this.title = title;
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PluginCategoryModel that = (PluginCategoryModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
