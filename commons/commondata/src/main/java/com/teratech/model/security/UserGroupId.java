package com.teratech.model.security;

import java.io.Serializable;
import java.util.Objects;


public class UserGroupId implements Serializable {

    private String pluginId;
    private String pluginVersion;
    private String userCode;

    public UserGroupId() {
    }

    public UserGroupId(String pluginId, String pluginVersion, String userCode) {
        this.pluginId = pluginId;
        this.pluginVersion = pluginVersion;
        this.userCode = userCode;
    }

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroupId that = (UserGroupId) o;
        return Objects.equals(pluginId, that.pluginId) && Objects.equals(pluginVersion, that.pluginVersion) && Objects.equals(userCode, that.userCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pluginId, pluginVersion, userCode);
    }
}
