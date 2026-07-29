package com.teratech.beans;

import com.teratech.model.PluginCategoryModel;

import java.io.Serializable;
import java.util.Objects;

public class PluginCategoryData implements Serializable {
    private String id;
    private String name;

    public PluginCategoryData(PluginCategoryModel category) {
        this.id = category.getCode();
        this.name = category.getTitle();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PluginCategoryData that = (PluginCategoryData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
