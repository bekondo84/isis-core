package com.teratech.isis.actions;

import com.teratech.actions.AbstractAction;
import com.teratech.actions.annotations.Action;
import com.teratech.actions.annotations.ActionMethod;
import com.teratech.beans.CustomFilterData;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.isis.popultor.CustomFilterPopulator;
import com.teratech.isis.popultor.FilterPopulator;
import com.teratech.metadata.ActionContextData;
import com.teratech.metadata.FilterData;
import com.teratech.model.cms.ActionType;
import com.teratech.model.generic.AbstractItem;
import com.teratech.model.settings.FilterModel;
import com.teratech.utils.ApplicationConstans;
import org.pf4j.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;
import tools.jackson.databind.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static com.teratech.utils.ApplicationConstans.Actions.DATA;

@Action("filterAction")
public class FilterAction extends AbstractAction {
    private static final Logger LOG = LoggerFactory.getLogger(FilterAction.class.getName());

    private final CustomFilterPopulator customFilterPopulator;
    private final FilterPopulator filterPopulator;
    /**
     *
     * @param pluginManager
     * @param flexibleSearch
     * @param persistenceManager
     * @param transactionTemplate
     */
    protected FilterAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate, CustomFilterPopulator customFilterPopulator, FilterPopulator filterPopulator) {
        super(pluginManager, flexibleSearch, persistenceManager, transactionTemplate);
        this.customFilterPopulator = customFilterPopulator;
        this.filterPopulator = filterPopulator;
    }

    /**
     * Save new user action
     * @param context
     * @return
     */
    @ActionMethod(value = "register", scope = ActionType.POST)
    public ActionContextData  saveFilterData(ActionContextData context) throws Exception {
        //Extract Data
        Object data = context.get(ApplicationConstans.Actions.DATA);
        String typeCode = context.get(ApplicationConstans.Actions.TYPECODE).toString();
        ObjectMapper mapper = new ObjectMapper();
        CustomFilterData customFilter =  mapper.convertValue(data, CustomFilterData.class);
       // LOG.info("saveFilterData customFilter={}", customFilter);
        FilterModel filter = new FilterModel();

        customFilterPopulator.populate(customFilter, filter);

         try {
            transactionTemplate.execute(status -> {
                try {
                    persistenceManager.save(filter);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return status;
            });
          } catch (RuntimeException e) {
            throw new ModelServiceException(e);
        }

        return context;
    }

    @Override
    public ActionContextData getItem(ActionContextData context) throws Exception {
        final Object object =  context.get(DATA);
        final Class clazz = getClassFromContext(context);
        //Convert Json String to instance of clazz
        final ObjectMapper mapper = new ObjectMapper();
        //mapper.isEnabled(SerializationFeature.FA)
        Object entity = mapper.convertValue(object, clazz);
        //Update the data context with the entity data fetch from database
        FilterModel source = (FilterModel) flexibleSearch.find((AbstractItem) entity);
        FilterModel target = new FilterModel();
        filterPopulator.populate(source, target);
        context.put(DATA,  target);
        return context;
    }

    @ActionMethod(value = "userfilters", scope = ActionType.POST)
    public ActionContextData loadCurrentUserFilter(ActionContextData context) throws Exception {
        String typeCode = context.get(ApplicationConstans.Actions.TYPECODE).toString();
        String query = "SELECT c FROM FilterModel c WHERE c.typeCode = :typeCode AND (c.user.id = :userId OR c.scope = '3') ORDER BY c.name DESC";
        String username = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        final List<CustomFilterData> filters = new ArrayList<>();
        List<FilterModel> data = flexibleSearch.doSearch(query, Map.of("userId", username, "typeCode", typeCode));

        if (!CollectionUtils.isEmpty(data)) {
            for  (FilterModel filter : data) {
                CustomFilterData filterData = new CustomFilterData();
                customFilterPopulator.reverse(filter, filterData);
                filters.add(filterData);
            }
        }
        context.put(DATA,  filters);
        return context;
    }

    @ActionMethod(value = "deletefilter", scope = ActionType.POST)
    public ActionContextData deleteFilter(ActionContextData context) throws Exception {
        Object data = context.get(DATA);
        ObjectMapper mapper = new ObjectMapper();
        CustomFilterData filterData = mapper.convertValue(data, CustomFilterData.class);
        FilterModel filter = flexibleSearch.find(new FilterModel(filterData.getId()));

        try {
            transactionTemplate.execute(status -> {
                try {
                    persistenceManager.delete(filter);
                    return status;
                } catch (ModelServiceException e) {
                    throw new RuntimeException(e);
                }

            });
        }catch (RuntimeException e) {
            throw new ModelServiceException(e);
        }
        context.put(DATA,  null);
        return  context;
    }
}
