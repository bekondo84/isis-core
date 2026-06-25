package com.teratech.actions;

import com.teratech.ModelServiceException;
import com.teratech.actions.annotations.ActionMethod;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.metadata.ActionContextData;
import com.teratech.metadata.SearchColumn;
import com.teratech.model.cms.ActionModel;
import com.teratech.model.cms.ActionType;
import com.teratech.model.generic.AbstractItem;
import com.teratech.tools.persistence.RestrictionsContainer;
import com.teratech.utils.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

import static com.teratech.utils.ApplicationConstans.Actions.*;

public abstract class AbstractAction implements ActionService{

    public static final String NOT_DATA_IN_CONTEXT_ERROR = String.format("No Data found in the action context data");
    public static final String NO_TYPE_FOUND_IN_CONTEXT_ERROR = String.format("No class name found in the action context data");
    public static final String NO_PLUGIN_FOUND_CONTEXT_ERROR = "No plugin found with ID %s in the action context data";
    protected final PluginManager pluginManager;
    protected final FlexibleSearch flexibleSearch;
    protected final PersistenceManager persistenceManager;
    protected final TransactionTemplate transactionTemplate;

    /**
     *
     * @param pluginManager
     */
    protected AbstractAction(PluginManager pluginManager, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, TransactionTemplate transactionTemplate) {
        this.pluginManager = pluginManager;
        this.flexibleSearch = flexibleSearch;
        this.persistenceManager = persistenceManager;
        this.transactionTemplate = transactionTemplate;
    }

    /** Execute action Node
     * @param action
     * @return
     */
    @Override
    public ActionContextData invoke(ActionModel action, String methodName, ActionType methodType, ActionContextData context) throws InvocationTargetException, IllegalAccessException {
        assert Objects.nonNull(action) : String.format("Action is null");
        Optional<Method> method = ClassUtils.getMethodsFor(getClass()).stream().filter(meth -> {
            if (meth.isAnnotationPresent(ActionMethod.class)) {
                ActionMethod annot = meth.getAnnotation(ActionMethod.class);
                return annot.value().equalsIgnoreCase(methodName) && annot.scope().equals(methodType);
            } else return false;
        }).findAny();
        if (method.isEmpty())
            throw new IllegalArgumentException(String.format("No method of name %s with type %s found for action %s", methodName, methodType, action.getCode()));

        //IF Action defined it own plugin replace the plugin by this one
        if (Objects.nonNull(action.getPlugin())) {
            context.put(PLUGIN, action.getPlugin().getId());
        }

        return (ActionContextData) method.get().invoke(this, context);
    }

    /**
     * Create new instance
     * @param context
     * @return
     */
    @ActionMethod(value = "create", scope = ActionType.POST)
    ActionContextData create(final ActionContextData context) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final String pluginId = (String) context.get(PLUGIN);
        final String className = (String) context.get(TYPE);

        assert StringUtils.isNotBlank(className) : NO_TYPE_FOUND_IN_CONTEXT_ERROR;

        final Class clazz = getClassType(pluginId, className);
        context.put(DATA, clazz.getDeclaredConstructor().newInstance());

        return context;
    }

    /**
     * Save or update new record in the database
     * @param context
     * @return
     */
    @ActionMethod(value = "save", scope = ActionType.POST)
     ActionContextData saveOrUpdate(final ActionContextData context) throws ClassNotFoundException, ModelServiceException {
         final Object object =  context.get(DATA);

        assert Objects.nonNull(object) : NOT_DATA_IN_CONTEXT_ERROR;

        final String pluginId = (String) context.get(PLUGIN);
        final String className = (String) context.get(TYPE);

        assert StringUtils.isNotBlank(className) : NO_TYPE_FOUND_IN_CONTEXT_ERROR;

        final Class clazz = getClassType(pluginId, className);
        //Convert Json String to instance of clazz
       final ObjectMapper mapper = new ObjectMapper();
       Object entity = mapper.convertValue(object, clazz);

       try {
           return transactionTemplate.execute(status -> {

               Object result = null;
               try {
                   result = persistenceManager.save((AbstractItem) entity);
               } catch (ModelServiceException | IllegalAccessException | NoSuchFieldException e) {
                   throw new RuntimeException(e);
               }
               //Update data context
               context.put(DATA, result);
               return context;
           });
       } catch (RuntimeException e) {
           throw new ModelServiceException(e);
       }
     }

    /**
     * Fetch List of items
     * @param context
     * @return
     */
     @ActionMethod(value = "fetchitems", scope = ActionType.POST)
    public ActionContextData getItems (final ActionContextData context) throws ClassNotFoundException, ParseException, IllegalAccessException {

         final String pluginId = (String) context.get(PLUGIN);
         final String className = (String) context.get(TYPE);

         assert StringUtils.isNotBlank(className) : NO_TYPE_FOUND_IN_CONTEXT_ERROR ;

         final Object searchObject =  context.get(SEARCH_PREDICAT);
         List<SearchColumn> searchs = new ArrayList<>();

         if (Objects.nonNull(searchObject)) {
             ObjectMapper mapper = new ObjectMapper();
             searchs = mapper.convertValue(searchObject, new TypeReference<List<SearchColumn>>() {
             });
         }
         //Initialize restriction container
         final RestrictionsContainer container = RestrictionsContainer.newInstance();

         if (!CollectionUtils.isEmpty(searchs)) {
            for (SearchColumn search : searchs) {
                Class type = Class.forName(search.getType());
                Object value = search.getValue();

                if (Number.class.isAssignableFrom(type)) {
                    value = NumberFormat.getNumberInstance().parse(search.getValue());
                }
                switch (search.getCond()) {
                    case "EQ" :
                        container.addEq(search.getFieldName(), search.getValue());
                        break;
                    case "NOTEQ":
                        container.addNotEq(search.getFieldName(), search.getValue());
                        break;
                    case "GE" :
                        container.addGe(search.getFieldName(), (Comparable)value);
                        break;
                    case "GT" :
                        container.addGt(search.getFieldName(), (Comparable)value);
                        break;
                    case "LT" :
                        container.addLt(search.getFieldName(), (Comparable)value);
                        break;
                    case "LE" :
                        container.addLe(search.getFieldName(), (Comparable)value);
                        break;
                    case "LIKE" :
                        container.addLike(search.getFieldName(), "%"+search.getValue()+"%");
                        break;
                    case "NOTLIKE" :
                        container.addNotLike(search.getFieldName(), "%"+search.getValue()+"%");
                        break;
                    case "ISEMPTY" :
                        container.addIsEmpty(search.getFieldName(), search.getValue());
                        break;
                    case "NOTEMPTY" :
                        container.addIsNotEmpty(search.getFieldName(), search.getValue());
                        break;
                    case "ISFALSE" :
                        container.addIsFalse(search.getFieldName());
                        break;
                    case "ISTRUE" :
                        container.addIsTrue(search.getFieldName());
                        break;
                }
            }
         }
         //Load class of entity
         final Class clazz = getClassType(pluginId, className);
          //Extraction des elements de pagination
         int startIndex = Objects.nonNull(context.get(START_INDEX)) ? (int) context.get(START_INDEX) : 0;
         int nbreOfItems = Objects.nonNull(context.get(NBREOFITEMS)) ? (int) context.get(NBREOFITEMS) : -1 ;

         //Fetch all data which map the criteria
         List datas = flexibleSearch.doSearch(clazz, container, new HashMap<>(), new HashSet<>(), startIndex, nbreOfItems);
         //Update the application context
         context.put(DATA, datas);
         //Return the context
         return context;
    }

    /**
     * Fetch single Item
     * @param context
     * @return
     */
    @ActionMethod(value = "fetchitem", scope = ActionType.POST)
    public ActionContextData getItem (final ActionContextData context) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        final Object object =  context.get(DATA);

        assert Objects.nonNull(object) : NOT_DATA_IN_CONTEXT_ERROR;

        final String pluginId = (String) context.get(PLUGIN);
        final String className = (String) context.get(TYPE);

         assert StringUtils.isNotBlank(className) : NO_TYPE_FOUND_IN_CONTEXT_ERROR;

        final Class clazz = getClassType(pluginId, className);
        //Convert Json String to instance of clazz
        final ObjectMapper mapper = new ObjectMapper();
        Object entity = mapper.convertValue(object, clazz);
        //System.out.println(String.format("Fetch instance --------------------- : %s", entity.getClass()));

        //Update the data context with the entity data fetch from database
        context.put(DATA, flexibleSearch.find((AbstractItem) entity));
        return context;
    }

    /**
     * Delete Items or list of items
     * @param context
     * @return
     */
   @ActionMethod(value = "delete", scope = ActionType.DELETE)
    public ActionContextData delete (final ActionContextData context) throws ModelServiceException {

       try {
           final Object object = context.get(DATA);

           assert Objects.nonNull(object) : NOT_DATA_IN_CONTEXT_ERROR;

           final String pluginId = (String) context.get(PLUGIN);
           final String className = (String) context.get(TYPE);

           assert StringUtils.isNotBlank(className) : NO_TYPE_FOUND_IN_CONTEXT_ERROR;

           return transactionTemplate.execute(status -> {
               try {
                   final Class clazz = getClassType(pluginId, className);
                   //Convert Json String to instance of clazz
                   final ObjectMapper mapper = new ObjectMapper();
                   persistenceManager.delete(mapper.convertValue(object, clazz));
               } catch (ModelServiceException | ClassNotFoundException e) {
                   throw new RuntimeException(e);
               }
               return context;
           });
       } catch (RuntimeException ex) {
           throw  new ModelServiceException(ex);
       }
   }

    /**
     *
     * @param pluginId
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    private Class getClassType(String pluginId, String className) throws ClassNotFoundException {
        PluginWrapper pluginWrapper = null ;
        if (!StringUtils.isBlank(pluginId)) {
            pluginWrapper = pluginManager.getPlugin(pluginId);
            assert Objects.nonNull(pluginWrapper) : String.format(NO_PLUGIN_FOUND_CONTEXT_ERROR, pluginId);
        }
        //Load class of entity
        final Class clazz = ClassUtils.loadClass(pluginWrapper, className);
        return clazz;
    }


}
