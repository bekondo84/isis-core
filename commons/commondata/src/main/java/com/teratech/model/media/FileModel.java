package com.teratech.model.media;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adm_file")
public class FileModel extends AbstractItem {
    @Id
    private String id;
    @Column(name = "file_name")
    private String name;
    @Column(name = "extension")
    private String type;
    private boolean confidential = false;
    private String description;
    private int size;
    private String url;


    public String getId() {
        return id;
    }

    public FileModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FileModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public FileModel setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isConfidential() {
        return confidential;
    }

    public FileModel setConfidential(boolean confidential) {
        this.confidential = confidential;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FileModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getSize() {
        return size;
    }

    public FileModel setSize(int size) {
        this.size = size;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public FileModel setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public Object getPk() {
        return id;
    }

    @Override
    public void toStringValue() {
       stringValue = name;
    }
}
