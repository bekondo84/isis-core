package com.teratech.model.settings;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "global_uitheme")
public class GlobalUiThemeSpecModel extends UiThemSpec{

    @Id
    private String code = "GLOBAL";
    private String name = null;
    private String slogan = null;

    public GlobalUiThemeSpecModel() {
    }

    public GlobalUiThemeSpecModel(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public GlobalUiThemeSpecModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }
    public GlobalUiThemeSpecModel setName(String name) {
        this.name = name;
        return this;
    }
    public String getSlogan() {
        return slogan;
    }
    public GlobalUiThemeSpecModel setSlogan(String slogan) {
        this.slogan = slogan;
        return this;
    }

    @Override
    public Object getPk() {
        return code;
    }

    @Override
    public void toStringValue() {
         stringValue = code;
    }
}
