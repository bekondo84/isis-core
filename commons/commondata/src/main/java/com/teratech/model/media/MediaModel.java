package com.teratech.model.media;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "adm_media")
public class MediaModel implements Serializable {

    @Id
    private String id ;
    private String url ;
    private String format;
    private boolean confidential = false;
    private Short width ;
    private Short height ;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "catalogid", referencedColumnName = "catalog_id"),
            @JoinColumn(name = "versionid", referencedColumnName = "version_id")
    })
    private CatalogVersionModel catalogVersion;

    public MediaModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isConfidential() {
        return confidential;
    }

    public void setConfidential(boolean confidential) {
        this.confidential = confidential;
    }

    public Short getWidth() {
        return width;
    }

    public void setWidth(Short width) {
        this.width = width;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public CatalogVersionModel getCatalogVersion() {
        return catalogVersion;
    }

    public void setCatalogVersion(CatalogVersionModel catalogVersion) {
        this.catalogVersion = catalogVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaModel that = (MediaModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
