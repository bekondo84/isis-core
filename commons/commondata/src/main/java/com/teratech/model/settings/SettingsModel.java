package com.teratech.model.settings;

import com.teratech.annotations.Combobox;
import com.teratech.annotations.Nullable;
import com.teratech.model.generic.AbstractItem;
import com.teratech.model.security.UserModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "adm_settings")
public class SettingsModel extends AbstractItem {

    @Id
    private String key;
    private String typeCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Nullable
    private UserModel user;
    @Column(nullable = false)
    private String value;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Combobox
    private String type;


    public SettingsModel(String key) {
        this.key = key;
    }

    public SettingsModel() {
    }

    public String getKey() {
        return key;
    }

    public SettingsModel setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SettingsModel setValue(String value) {
        this.value = value;
        return  this;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return key;
    }

    /**
     * Build and convert the entity in String
     */
    @Override
    public void toStringValue() {
         stringValue = key;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
