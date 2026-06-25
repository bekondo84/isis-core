package com.teratech.isis.services.impl;

import com.teratech.model.generic.AbstractTenant;
import com.teratech.model.generic.AbstractTenant;
import com.teratech.model.media.MediaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.*;


@Entity
public class CompanyTest
    extends AbstractTenant
{
    /**
     * Name of the Entity Without Model
     */
    public final static String _TYPECODE = "Company";
    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "p_logo", nullable = true)
    private MediaModel logo;
    /**
     *
     */
    @Id
    @Column(name = "p_code", nullable = true)
    private String code;
    /**
     *
     */

    private String name;
    /**
     *
     */
    @Lob
    @Column(name = "p_adresse")
    private String adresse;
    /**
     *
     */
    @Column(name = "p_town", nullable = true)
    private String town;
    /**
     *
     */
    @Column(name = "p_country", nullable = true)
    private String country;
    /**
     *
     */
    @Column(name = "p_postal", nullable = true)
    private String postal;
    /**
     *
     */
    @Column(name = "p_website", nullable = true)
    private String website;
    /**
     *
     */
    @Column(name = "p_phone", nullable = true)
    private String phone;
    /**
     *
     */
    @Column(name = "p_fax", nullable = true)
    private String fax;
    /**
     *
     */
    @Column(name = "p_email", nullable = true)
    private String email;
    /**
     * @Num�ro unique d'identification
     */
    @Column(name = "p_nui", nullable = true)
    private String nui;

    /**
     * Default constructor
     */
    public CompanyTest() {

    }

    /**
     * Getter of field logo
     */
    public MediaModel getLogo() {
        return logo;
    }

    /**
     * Setter of field logo
     */
    public void setLogo(final MediaModel logo) {
        this.logo = logo;
    }

    /**
     * Getter of field code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter of field code
     */
    public void setCode(final String code) {
        this.code = code;
    }


    /**
     * Getter of field adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setter of field adresse
     */
    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }

    /**
     * Getter of field town
     */
    public String getTown() {
        return town;
    }

    /**
     * Setter of field town
     */
    public void setTown(final String town) {
        this.town = town;
    }

    /**
     * Getter of field country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter of field country
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * Getter of field postal
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Setter of field postal
     */
    public void setPostal(final String postal) {
        this.postal = postal;
    }


    /**
     * Getter of field website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Setter of field website
     */
    public void setWebsite(final String website) {
        this.website = website;
    }

    /**
     * Getter of field phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter of field phone
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * Getter of field fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * Setter of field fax
     */
    public void setFax(final String fax) {
        this.fax = fax;
    }

    /**
     * Getter of field email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter of field email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Getter of field nui
     */
    public String getNui() {
        return nui;
    }

    /**
     * Setter of field nui
     */
    public void setNui(final String nui) {
        this.nui = nui;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
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
