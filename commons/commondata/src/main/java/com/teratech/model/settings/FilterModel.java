package com.teratech.model.settings;

import com.teratech.annotations.Action;
import com.teratech.annotations.Combobox;
import com.teratech.model.generic.AbstractItem;
import com.teratech.model.security.UserGroupModel;
import com.teratech.model.security.UserModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Action("filterAction")
@Entity
@Table(name = "adm_filter")
public class FilterModel extends AbstractItem {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @Combobox
    @Column(nullable = false)
    private String scope;

    @Combobox
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String typeCode;

    @Column(nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel  user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private UserGroupModel group;

    public FilterModel() {
    }

    public FilterModel(long id, String type, String name, String scope, String value) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.scope = scope;
        this.value = value;
    }

    public FilterModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public UserGroupModel getGroup() {
        return group;
    }

    public void setGroup(UserGroupModel group) {
        this.group = group;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setCreateDate(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastModif(LocalDateTime lastModif) {
        this.lastModif = lastModif;
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
