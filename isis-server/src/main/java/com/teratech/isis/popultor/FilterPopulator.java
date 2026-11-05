package com.teratech.isis.popultor;

import com.teratech.model.security.UserGroupModel;
import com.teratech.model.security.UserModel;
import com.teratech.model.settings.FilterModel;
import com.teratech.populator.Populator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FilterPopulator implements Populator<FilterModel, FilterModel> {

    @Override
    public void populate(FilterModel source, FilterModel target) throws Exception {
        target.setName(source.getName());
        target.setId(source.getId());
        target.setScope(source.getScope());
        target.setType(source.getType());
        target.setTypeCode(source.getTypeCode());
        target.setValue(source.getValue());
        target.setCreateDate(source.getCreatedAt());
        target.setLastModif(source.getLastModif());

        if (Objects.nonNull(source.getUser())) {
            UserModel user = new UserModel();
            user.setCode(source.getUser().getCode());
            user.setName(source.getUser().getName());
            user.setSurname(source.getUser().getSurname());
            user.setEmail(source.getUser().getEmail());
            user.toStringValue();
            target.setUser(user);
        }
        if (Objects.nonNull(source.getGroup())) {
            UserGroupModel userGroup = new UserGroupModel();
            userGroup.setCode(source.getGroup().getCode());
            userGroup.setName(source.getGroup().getName());
            userGroup.setDescription(source.getGroup().getDescription());
            userGroup.toStringValue();
            target.setGroup(userGroup);
        }
    }
}
