package com.teratech.model.security;

import com.teratech.model.generic.AbstractBusinessEntity;
import com.teratech.model.i18n.LocalModel;
import com.teratech.model.media.MediaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bs_user")
public class UserModel extends AbstractBusinessEntity {

    @Id
    private String code ;
    private String name ;
    private String surname;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "image", referencedColumnName = "id")
    private MediaModel image ;
    private boolean active = true;
    private boolean locked = false;
    @ManyToOne
    @JoinColumn (name = "langue", referencedColumnName = "code")
    private LocalModel language ;
    private String token ;
    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserGroupModel> userGroups = new ArrayList<>();

    /**
     *
     */
    public UserModel() {
    }

    /**
     *
     * @param code
     */
    public UserModel(String code) {
        this.code = code;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MediaModel getImage() {
        return image;
    }

    public void setImage(MediaModel image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public LocalModel getLanguage() {
        return language;
    }

    public void setLanguage(LocalModel language) {
        this.language = language;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void addGroup (UserGroupModel group) {
        userGroups.add(group);
    }
    public List<UserGroupModel> getUserGroups() {
        return Collections.unmodifiableList(userGroups);
    }

    public void setUserGroups(List<UserGroupModel> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(code, userModel.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
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
}
