package com.teratech.isis.actions;

import com.teratech.actions.AbstractAction;
import com.teratech.actions.annotations.Action;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.isis.popultor.GlobalUiThemeSpecPopulator;
import com.teratech.metadata.ActionContextData;
import com.teratech.model.settings.GlobalUiThemeSpecModel;
import com.teratech.utils.ApplicationConstans;
import org.pf4j.PluginManager;
import org.springframework.transaction.support.TransactionTemplate;
import tools.jackson.databind.ObjectMapper;

@Action
public class GlobalUiThemeSpecAction extends AbstractAction {

    public static final String GLOBAL_SETTINGS = "GLOBAL_SETTINGS";
    private final GlobalUiThemeSpecPopulator populator;
    /**
     *
     * @param pluginManager
     * @param flexibleSearch
     * @param persistenceManager
     * @param transactionTemplate
     */
    protected GlobalUiThemeSpecAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate, GlobalUiThemeSpecPopulator populator) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
        this.populator = populator;
    }


    @Override
    public ActionContextData saveOrUpdate(ActionContextData context) throws Exception {
        final Object data = context.get(ApplicationConstans.Actions.DATA);
        final ObjectMapper mapper = new ObjectMapper();
        final GlobalUiThemeSpecModel uiTheme =  mapper.convertValue(data, GlobalUiThemeSpecModel.class);
        uiTheme.setCode(GLOBAL_SETTINGS);

        try {
            GlobalUiThemeSpecModel uiThemeSpec = transactionTemplate.execute(status -> {
                try {
                    GlobalUiThemeSpecModel uiThemeDb = flexibleSearch.find(uiTheme);

                    if (uiThemeDb == null) {
                        uiThemeDb = new GlobalUiThemeSpecModel();
                    }
                    persistenceManager.save(uiThemeDb);
                    populator.populate(uiTheme, uiThemeDb);

                    return uiThemeDb;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            context.put(ApplicationConstans.Actions.DATA, uiThemeSpec);
        } catch (RuntimeException e) {
            throw new Exception(e);
        }

        return context;
    }
}
