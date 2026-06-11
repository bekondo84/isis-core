package com.teratech.model;

import java.io.Serializable;
import java.util.Objects;

public class PluginId implements Serializable {
    private String id ;
    private String version;


    public PluginId() {
    }

    public PluginId(String id, String version) {
        this.id = id;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PluginId pluginId = (PluginId) o;
        return Objects.equals(id, pluginId.id) && Objects.equals(version, pluginId.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }
}
