package com.teratech.model.media;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "adm_version")
public class VersionModel extends AbstractItem implements Serializable {

    @Id
    private String id;
    private String name ;

    public VersionModel() {
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

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VersionModel that = (VersionModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
