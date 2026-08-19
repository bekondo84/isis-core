package com.teratech.model.security;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "bs_usergroup")
public class UserGroupModel extends AbstractItem {

    @Id
    private String code;
    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id"),
            @JoinColumn (name = "plugin_version", referencedColumnName = "version")
    })
    private PluginModel plugin;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn (name = "ug_code", referencedColumnName = "code")
    private List<UserRigthModel> userRigths = new ArrayList<>();


    public List<UserRigthModel> getUserRigths() {
        return userRigths;
    }

    public void setUserRigths(List<UserRigthModel> userRigths) {
        this.userRigths = Collections.unmodifiableList(userRigths);
    }

    public void addUserRigth(UserRigthModel userRigth) {
        if (!userRigths.contains(userRigth)) {
            userRigths.add(userRigth);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public void setPlugin(PluginModel plugin) {
        this.plugin = plugin;
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return code;
    }

    /**
     * Build and convert the entity in String
     */
    @Override
    public void toStringValue() {
        stringValue = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroupModel that = (UserGroupModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
