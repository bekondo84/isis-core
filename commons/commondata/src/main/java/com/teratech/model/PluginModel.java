package com.teratech.model;

import com.teratech.model.generic.AbstractItem;
import com.teratech.model.media.MediaModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@IdClass(PluginId.class)
@Table(name = "adm_plugin")
public class PluginModel extends AbstractItem implements Serializable {

    @Id
    private String id ;
    @Id
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date instaldate;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "adm_plugin_depend",
            joinColumns ={
                    @JoinColumn(name = "plugin_id", referencedColumnName = "id"),
                    @JoinColumn(name = "plugin_version", referencedColumnName = "version")
            }
    )
    @Column(name = "name")
    private List<String> dependencies = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "adm_plugin_media",
          joinColumns = {
                  @JoinColumn(name = "plugin_id" , referencedColumnName = "id"),
                  @JoinColumn (name = "plugin_version", referencedColumnName = "version")
          },
    inverseJoinColumns = @JoinColumn(name = "media_id", referencedColumnName = "id"))
    private List<MediaModel> medias = new ArrayList<>();


    public PluginModel() {
    }

    /**
     *
     * @param id
     * @param version
     */
    public PluginModel(String id, String version) {
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

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PluginModel that = (PluginModel) o;
        return Objects.equals(id, that.id) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }
}
