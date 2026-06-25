package com.teratech.model.cms;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cms_metafield")
public class MetaFieldModel extends AbstractItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String className;
    private Boolean persist;
    private String defaultValue;
    private boolean primaryKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Boolean getPersist() {
        return persist;
    }

    public void setPersist(Boolean persist) {
        this.persist = persist;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaFieldModel that = (MetaFieldModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return id;
    }
}
