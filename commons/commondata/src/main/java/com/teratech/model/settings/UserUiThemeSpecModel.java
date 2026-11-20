package com.teratech.model.settings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_uitheme")
public class UserUiThemeSpecModel extends UiThemSpec{
    @Id
    @Column(name = "user_id")
    private String userid;
    @Column(name = "business_id")
    private String businessid;

    public UserUiThemeSpecModel(String userid) {
        this.userid = userid;
    }

    public UserUiThemeSpecModel() {
    }

    public String getUserid() {
        return userid;
    }

    public UserUiThemeSpecModel setUserid(String userid) {
        this.userid = userid;
        return this;
    }

    public String getBusinessid() {
        return businessid;
    }

    public UserUiThemeSpecModel setBusinessid(String businessid) {
        this.businessid = businessid;
        return this;
    }

    @Override
    public Object getPk() {
        return userid;
    }

    @Override
    public void toStringValue() {
          stringValue = userid;
    }
}
