package com.teratech.isis.converter;

import com.teratech.convertor.Convertor;
import com.teratech.model.security.UserModel;
import com.teratech.model.settings.SettingsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SettingsConverter implements Convertor<SettingsModel, SettingsModel> {

    @Autowired
    private UserConverter userConverter;


    @Override
    public SettingsModel convert(SettingsModel source) {
        final SettingsModel target = new SettingsModel();
        target.setName(source.getName());
        target.setValue(source.getValue());
        target.setType(source.getType());
        target.setCreatedAt(source.getCreatedAt());
        target.setKey(source.getKey());
        target.setTypeCode(source.getTypeCode());

        if (Objects.nonNull(source.getUser())) {
            target.setUser(userConverter.convert(source.getUser()));
        }

        return target;
    }
}
