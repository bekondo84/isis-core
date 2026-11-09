package com.teratech.isis.popultor;

import com.teratech.beans.SettingsData;
import com.teratech.dao.FlexibleSearch;
import com.teratech.metadata.MetaColumn;
import com.teratech.model.security.UserModel;
import com.teratech.model.settings.SettingsModel;
import com.teratech.populator.Populator;
import com.teratech.services.I18NService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SettingsPopulator implements Populator <SettingsData, SettingsModel> {

    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private I18NService i18NService;


    @Override
    public void populate(SettingsData source, SettingsModel target) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        target.setTypeCode(source.getTypeCode());
        target.setType(source.getType());

        if (!CollectionUtils.isEmpty(source.getColumns())) {
            target.setValue(mapper.writeValueAsString(source.getColumns()));
        }
        target.setName(String.format(i18NService.getMessage("Settings.table.message"), source.getTypeCode()));
        String usernane = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        target.setKey(String.format("%s_%s", usernane.toLowerCase(), source.getTypeCode().toLowerCase()));

        SettingsModel settings = flexibleSearch.find(target);

        if (Objects.nonNull(settings)) {
            target.setCreatedAt(settings.getCreatedAt());
            target.setUser(settings.getUser());
        } else {
            UserModel user = flexibleSearch.find(new UserModel(usernane));
            target.setUser(user);
        }

        //throw new Exception(mapper.writeValueAsString(source.getColumns().stream().map(col -> col.getSequence()).collect(Collectors.toList())));
    }

    @Override
    public void reverse(SettingsModel source, SettingsData target) throws Exception {

        final ObjectMapper mapper = new ObjectMapper();

        target.setTypeCode(source.getTypeCode());
        target.setTypeCode(source.getTypeCode());

        List<MetaColumn> columns = mapper.readValue(source.getValue(), new TypeReference<List<MetaColumn>>() {
            });
        target.setColumns(columns);
    }
}
