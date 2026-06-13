package com.teratech.model.media;

import com.teratech.model.generic.ItemModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "adm_catalogversion")
public class CatalogVersionModel extends ItemModel implements Serializable {

    @EmbeddedId
    private CatalogVersionId id = new CatalogVersionId();

    @MapsId("catalogid")
    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private CatalogModel catalog;
    @MapsId("versionid")
    @ManyToOne
    @JoinColumn(name = "version_id")
    private VersionModel version;

    public CatalogVersionModel() {
    }

    public CatalogVersionModel(CatalogModel catalog, VersionModel version) {
        this.catalog = catalog;
        this.version = version;
        this.id = new CatalogVersionId(catalog.getId(), version.getId());
    }

    public CatalogVersionId getId() {
        return id;
    }

    public void setId(CatalogVersionId id) {
        this.id = id;
    }

    public CatalogModel getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogModel catalog) {
        this.catalog = catalog;
    }

    public VersionModel getVersion() {
        return version;
    }

    public void setVersion(VersionModel version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogVersionModel that = (CatalogVersionModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
