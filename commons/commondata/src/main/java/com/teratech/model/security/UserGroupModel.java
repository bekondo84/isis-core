package com.teratech.model.security;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "APP_USER")
@Entity
@IdClass(UserGroupId.class)
@Table(name = "bs_usergroup")
public class UserGroupModel extends AbstractItem {

    @Id
    @Column(name = "plugin_id")
    private String pluginId;
    @Id
    @Column(name = "plugin_version")
    private String pluginVersion;
    @Id
    @Column(name = "user_code")
    private String userCode;
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "code", insertable = false, updatable = false)
    private UserModel user ;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id", insertable = false,updatable = false),
            @JoinColumn (name = "plugin_version", referencedColumnName = "version", insertable = false, updatable = false)
    })
    private PluginModel plugin;

    private String name;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumns ({
            @JoinColumn (name = "plugin_id", referencedColumnName = "plugin_id"),
            @JoinColumn (name = "plugin_version", referencedColumnName = "plugin_version"),
            @JoinColumn (name = "user_code", referencedColumnName = "user_code")
    })
    private List<UserRigthModel> userRigths = new ArrayList<>();

    public String getPluginId() {
        return pluginId;
    }

    public String getPluginVersion() {
        return pluginVersion;
    }


    public String getUserCode() {
        return userCode;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;

        if (Objects.nonNull(user)) {
            this.userCode = user.getCode();
        }

    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public void setPlugin(PluginModel plugin) {
        this.plugin = plugin;
        if (Objects.nonNull(plugin)) {
            this.pluginId = plugin.getId();
            this.pluginVersion = plugin.getVersion();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRigthModel> getUserRigths() {
        return userRigths;
    }

    public void setUserRigths(List<UserRigthModel> userRigths) {
        this.userRigths = userRigths;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroupModel that = (UserGroupModel) o;
        return Objects.equals(pluginId, that.pluginId) && Objects.equals(pluginVersion, that.pluginVersion) && Objects.equals(userCode, that.userCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pluginId, pluginVersion, userCode);
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return new UserGroupId(pluginId, pluginVersion, userCode);
    }
}
