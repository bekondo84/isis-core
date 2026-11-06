package com.teratech.isis.actions;

import com.teratech.actions.AbstractAction;
import com.teratech.actions.annotations.Action;
import com.teratech.actions.annotations.ActionMethod;
import com.teratech.beans.SettingsData;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.isis.converter.SettingsConverter;
import com.teratech.isis.popultor.SettingsPopulator;
import com.teratech.metadata.ActionContextData;
import com.teratech.model.cms.ActionType;
import com.teratech.model.generic.AbstractItem;
import com.teratech.model.settings.SettingsModel;
import com.teratech.tools.persistence.RestrictionsContainer;
import com.teratech.utils.ApplicationConstans;
import org.pf4j.PluginManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.support.TransactionTemplate;
import tools.jackson.databind.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

import static com.teratech.utils.ApplicationConstans.Actions.DATA;

@Action("settingsAction")
public class SettingsAction extends AbstractAction {


    private final SettingsPopulator settingsPopulator;
    private final SettingsConverter settingsConverter;
    /**
     *
     * @param pluginManager
     * @param flexibleSearch
     * @param persistenceManager
     * @param transactionTemplate
     */
    protected SettingsAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate, SettingsPopulator settingsPopulator, SettingsConverter settingsConverter) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
        this.settingsPopulator = settingsPopulator;
        this.settingsConverter = settingsConverter;
    }

    @ActionMethod(value = "get_user_table_settings", scope = ActionType.POST)
    public  ActionContextData getCurrentUserTableSettings(ActionContextData context) throws Exception {

        String typeCode = Objects.requireNonNull(context.get(ApplicationConstans.Actions.TYPECODE)).toString();
        String username = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        //String type = Objects.requireNonNull(context.get("type")).toString();
        String pk = String.format("%s_%s", username.toLowerCase(), typeCode.toLowerCase());
        SettingsModel settings = flexibleSearch.find(new SettingsModel(pk));

        SettingsData settingsData = new SettingsData();

        if (Objects.nonNull(settings)) {
            settingsPopulator.reverse(settings, settingsData);
        }
        context.put(DATA,  settingsData);

        return context;
    }
    @ActionMethod(value = "save_table_settings", scope = ActionType.POST)
    public ActionContextData  saveTableAction(ActionContextData actionContextData) throws Exception {
       Object data = actionContextData.get(ApplicationConstans.Actions.DATA);
        ObjectMapper mapper = new ObjectMapper();
        SettingsData settingsData = mapper.convertValue(data, SettingsData.class);
        System.out.println(String.format("Saving settings to table: %s", settingsData.getColumns().size()));
        SettingsModel settings = new SettingsModel();
        settingsPopulator.populate(settingsData, settings);

        try {
            transactionTemplate.execute(status -> {
                try {
                    persistenceManager.save(settings);
                    return status;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (RuntimeException e) {
            throw new ModelServiceException(e);
        }
        return actionContextData;
    }


    @Override
    public ActionContextData getItem(ActionContextData context) throws Exception {
        final Object object =  context.get(DATA);
        final ObjectMapper mapper = new ObjectMapper();
        //mapper.isEnabled(SerializationFeature.FA)
        SettingsModel entity = mapper.convertValue(object, SettingsModel.class);
        //Update the data context with the entity data fetch from database
        SettingsModel settings = flexibleSearch.find(entity);

        if (Objects.nonNull(settings)) {
            context.put(DATA, settingsConverter.convert(settings));
        }

        return context;
    }
}
