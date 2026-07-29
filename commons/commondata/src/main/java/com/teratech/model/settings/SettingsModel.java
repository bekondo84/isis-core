package com.teratech.model.settings;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adm_settings")
public class SettingsModel extends AbstractItem {

    @Id
    private String key;
    private String value;

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
}
