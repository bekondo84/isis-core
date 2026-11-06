package com.teratech.isis.converter;

import com.teratech.convertor.Convertor;
import com.teratech.model.security.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Convertor<UserModel, UserModel> {
    @Override
    public UserModel convert(UserModel source) {
        UserModel user = new UserModel();
        user.setName(source.getName());
        user.setEmail(source.getEmail());
        user.setCode(source.getPassword());
        user.setActive(source.isActive());
        user.setSurname(source.getSurname());
        user.setLanguage(source.getLanguage());
        user.setActive(source.isActive());
        user.setLocked(source.isLocked());
        user.toStringValue();
        return user;
    }
}
