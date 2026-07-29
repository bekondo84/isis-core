package com.teratech.isis.services.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.exceptions.ApplicationException;
import com.teratech.utils.ReflectionUtils;
import com.teratech.metadata.WCMS;
import com.teratech.model.PluginModel;
import com.teratech.model.cms.MetaFieldModel;
import com.teratech.model.cms.MetaTypeModel;
import com.teratech.services.MetaTypeService;
import com.teratech.tools.persistence.RestrictionsContainer;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import jakarta.persistence.*;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class MetaTypeServiceImpl implements MetaTypeService {

    private final Logger logger;
    private final PersistenceManager persistenceManager;
    private final FlexibleSearch flexibleSearch;

    /**
     *
     * @param persistenceManager
     * @param flexibleSearch
     */
    @Autowired
    public MetaTypeServiceImpl(Logger logger, PersistenceManager persistenceManager, FlexibleSearch flexibleSearch) {
        this.logger = logger;
        this.persistenceManager = persistenceManager;
        this.flexibleSearch = flexibleSearch;
    }

    /**
     * @param wrapper
     */
    @Override
    public void loadMetaTypeClasses(PluginWrapper wrapper) throws ApplicationException {

        //First Clean MetaType data before load
        cleanMetaTypesClasses(wrapper);
        //Load MetaType data
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        PluginModel plugin = null ;
        if (Objects.nonNull(wrapper)) {
            loader = wrapper.getPluginClassLoader();
        }
        final ClassLoader useLoarder = loader;

        try (ScanResult scanner = new ClassGraph()
                .overrideClassLoaders(loader)
                .enableClassInfo()
                .scan()) {

            if (Objects.nonNull(wrapper)) {
                plugin = flexibleSearch.find(new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion()));
            }

            for (ClassInfo ci : scanner.getAllClasses()) {
                Class clazz = loader.loadClass(ci.getName());

                if (!clazz.isAnnotationPresent(Entity.class))
                    continue;

                WCMS wcms = (WCMS) clazz.getDeclaredAnnotation(WCMS.class);
                Table tableAnnot = (Table) clazz.getDeclaredAnnotation(Table.class);

                MetaTypeModel metaType = new MetaTypeModel(clazz.getSimpleName());
                metaType.setClassName(clazz.getName())
                        .setPlugin(plugin)
                        .setDescrip(String.format("Meta date de l'entité %s", clazz.getName()))
                        .setDbtable(tableAnnot.name())
                        .setConcrete(!ReflectionUtils.isNotConcrete(clazz));

                if (Objects.nonNull(wcms)) {
                    metaType.setTemplate(wcms.template());
                }
                persistenceManager.save(metaType);
                //Build of MetaType
                for (Field field : clazz.getDeclaredFields()) {
                    MetaFieldModel metaField = new MetaFieldModel();
                    metaField.setName(field.getName())
                            .setPrimaryKey(field.isAnnotationPresent(Id.class))
                            .setBdcolumn(field.isAnnotationPresent(Column.class) ? field.getDeclaredAnnotation(Column.class).name() : field.getName())
                            .setPersist(!field.isAnnotationPresent(Transient.class))
                            .setClassName(field.getType().getName());
                    //Cas ou le type est une list
                    if (Collection.class.isAssignableFrom(field.getType())) {
                        metaField.setClassName(ReflectionUtils.getGenericType(field).getName());
                    }
                    metaType.addField(metaField);
                }
                //Persist metaType with fields
                persistenceManager.save(metaType);
            }

        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }

    /**
     * Delete all metatype for given plugin
     *
     * @param wrapper
     * @throws ApplicationException
     */
    @Override
    public void cleanMetaTypesClasses(PluginWrapper wrapper) throws ApplicationException {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("plugin.id", wrapper.getPluginId());
        container.addEq("plugin.version", wrapper.getDescriptor().getVersion());
        try {
            List<MetaTypeModel> metaFields = flexibleSearch.doSearch(MetaTypeModel.class, container, new HashMap<>(), new HashSet<>(), 0, -1);
            persistenceManager.delete(metaFields.stream().toArray());
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }
}
