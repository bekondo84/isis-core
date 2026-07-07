package com.teratech.beans;

import com.teratech.metadata.AbstractMenuData;
import com.teratech.model.cms.AbstractMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PluginData implements Serializable {
    private String id ;
    private String version;
    private String name;
    private int sequence;
    private boolean autoInstall = false;
    private String summary;
    private String description;
    private String category;
    private String email ;
    private String website;
    private String phone;
    private boolean install = false;
    private Date instaldate;
    private List<String> dependencies = new ArrayList<>();
    private List<MediaData> medias = new ArrayList<>();

    private List<AbstractMenuData> menus = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public boolean isAutoInstall() {
        return autoInstall;
    }

    public void setAutoInstall(boolean autoInstall) {
        this.autoInstall = autoInstall;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isInstall() {
        return install;
    }

    public void setInstall(boolean install) {
        this.install = install;
    }

    public Date getInstaldate() {
        return instaldate;
    }

    public void setInstaldate(Date instaldate) {
        this.instaldate = instaldate;
    }

    public List<MediaData> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaData> medias) {
        this.medias = medias;
    }

    public List<AbstractMenuData> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public void setMenus(List<AbstractMenuData> menus) {
        this.menus = menus;
    }

    public void addMenu(AbstractMenuData menu) {
        this.menus.add(menu);

    }
}
