package com.teratech.model.media;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CatalogVersionId implements Serializable {
    private String catalogid;
    private String versionid;

    public CatalogVersionId() {
    }

    public CatalogVersionId(String catalogid, String versionid) {
        this.catalogid = catalogid;
        this.versionid = versionid;
    }

    public String getCatalogid() {
        return catalogid;
    }

    public void setCatalogid(String catalogid) {
        this.catalogid = catalogid;
    }

    public String getVersionid() {
        return versionid;
    }

    public void setVersionid(String versionid) {
        this.versionid = versionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogVersionId that = (CatalogVersionId) o;
        return Objects.equals(catalogid, that.catalogid) && Objects.equals(versionid, that.versionid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogid, versionid);
    }
}
