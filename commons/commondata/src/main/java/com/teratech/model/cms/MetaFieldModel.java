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
    private String bdcolumn;
    private Boolean persist;
    private String defaultValue;
    private boolean primaryKey;

    public Long getId() {
        return id;
    }

    public MetaFieldModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MetaFieldModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public MetaFieldModel setClassName(String className) {
        this.className = className;
        return this;
    }

    public Boolean getPersist() {
        return persist;
    }

    public MetaFieldModel setPersist(Boolean persist) {
        this.persist = persist;
        return this;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public MetaFieldModel setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public MetaFieldModel setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }

    public String getBdcolumn() {
        return bdcolumn;
    }

    public MetaFieldModel setBdcolumn(String bdcolumn) {
        this.bdcolumn = bdcolumn;
        return this;
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

    /**
     * Build and convert the entity in String
     */
    @Override
    public void toStringValue() {
        stringValue = name;
    }
}
