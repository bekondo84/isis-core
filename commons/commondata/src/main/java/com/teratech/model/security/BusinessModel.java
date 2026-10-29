package com.teratech.model.security;

import com.teratech.annotations.Media;
import com.teratech.model.generic.AbstractItem;
import com.teratech.model.media.MediaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bs_entity")
public class BusinessModel extends AbstractItem {

    @Id
    private String code;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nui;
    @Media
    @ManyToOne
    @JoinColumn(name = "logo", referencedColumnName = "id")
    private MediaModel logo;
    @Column(nullable = false)
    private String name ;
    private String adress;
    private String city;
    private String postal;
    private String slogan;
    private String website;
    @Column(nullable = false)
    private String phone;
    private String fax;



    public BusinessModel() {
    }

    public BusinessModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNui() {
        return nui;
    }

    public void setNui(String nui) {
        this.nui = nui;
    }

    public MediaModel getLogo() {
        return logo;
    }

    public void setLogo(MediaModel logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
        stringValue = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessModel that = (BusinessModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
