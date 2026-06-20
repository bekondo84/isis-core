package com.teratech.isis.services.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.jaxb.entities.*;
import com.teratech.metadata.*;
import com.teratech.model.cms.MenuItemModel;
import com.teratech.model.cms.MetaTypeModel;
import com.teratech.services.JAXBService;
import com.teratech.services.MetaDataService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.JAXBException;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MetaDataServiceImpl implements MetaDataService {

    //private static final Logger LOG = LoggerFactory.getLogger(MetaDataServiceImpl.class);

    private final PluginManager pluginManager;
    private JAXBService jaxbService;
    private final FlexibleSearch flexibleSearch;

    @Autowired
    public MetaDataServiceImpl(PluginManager pluginManager, FlexibleSearch flexibleSearch) {
        this.pluginManager = pluginManager;
        this.flexibleSearch = flexibleSearch;
        jaxbService = new JAXBServiceImpl();
    }

    /**
     * Build MetaData From Navigation Node
     * @param menuItem
     * @return
     * @throws ClassNotFoundException
     * @throws JAXBException
     */
    @Override
    public MetaData buildMetaDataFrom(MenuItemModel menuItem) throws ClassNotFoundException, JAXBException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        //Get Type code
        MetaTypeModel metaType = (MetaTypeModel) flexibleSearch.find(new MetaTypeModel(menuItem.getType()));
        if (Objects.isNull(metaType))
            throw new IllegalArgumentException(String.format("No MetaType found for type code %s", menuItem.getType()));

        PluginWrapper wrapper = null ;
        final String pluginid = Objects.nonNull(metaType.getPlugin()) ? metaType.getPlugin().getId() : null;
        if (StringUtils.isNotBlank(pluginid)) {
            wrapper = pluginManager.getPlugin(pluginid);
        }
        MetaData metaData = null ;
        Class clazz =  null;

        if (Objects.isNull(wrapper)) {
            clazz = Class.forName(metaType.getClassName());
        } else {
            clazz = wrapper.getPluginClassLoader().loadClass(metaType.getClassName());
        }
        return buildMetaDataFrom(clazz, wrapper, metaType.getTemplate(), true);
    }

    /**
     * Build MetaData From Class definition
     * @param clazz
     * @param wrapper
     * @param templatename
     * @param principal :
     * @return
     * @throws JAXBException
     */
    @Override
    public MetaData buildMetaDataFrom(Class clazz, PluginWrapper wrapper, String templatename, boolean principal) throws JAXBException {
        final MetaData metaData = new MetaData(clazz.getName(), clazz.getSimpleName().toLowerCase());
        final EditorAreaData editorArea = new EditorAreaData();
        metaData.setEditorarea(editorArea);
        final ListViewData listView = new ListViewData();
        metaData.setListView(listView);
        //Check if there is a template with name : templatename
        Context template = jaxbService.getTemplateFromResources(wrapper, templatename);

        //Extract all declared fields of this class and it superclass
        List<Field> fields = getDeclaredFieldsFrom(clazz);

        if (Objects.nonNull(template)) {
            //Build ListView Data
            buildListView(wrapper, template, metaData, fields);
            //Build EditorArea Data
            buildEditorArea(wrapper, template, metaData, fields, principal);

            buildKabanView(template, metaData);
        } else  {
            //Build ListView Data
            buildListView(wrapper, clazz, metaData, fields, principal);
            //Build Editor Area
            buildEditorArea(wrapper, clazz, metaData, fields, principal);
        }

        return metaData;
    }

    private void buildKabanView(Context template, MetaData metaData) {
        if (Objects.isNull(template)
                || Objects.isNull(template.getListView())
                || Objects.isNull(template.getListView().getKanban())
                || StringUtils.isBlank(template.getListView().getKanban().getTemplate()))
            return;
        KabanViewData kabanViewData = new KabanViewData(template.getListView().getKanban().getTemplate());
        metaData.setKabanView(kabanViewData);
    }

    private void buildEditorArea(PluginWrapper wrapper, Class clazz, MetaData metaData, List<Field> fields, boolean principal) throws JAXBException {
         FormData formData = new FormData();
        metaData.getEditorarea().setForm(formData);
        List<Field> simpleFields = fields.stream().filter(field -> !Collection.class.isAssignableFrom(field.getType())).collect(Collectors.toUnmodifiableList());
        List<Field> collectionsFields = fields.stream().filter(field -> Collection.class.isAssignableFrom(field.getType())).collect(Collectors.toUnmodifiableList());
        SectionData commonSection = new SectionData("hac.commons.section", "hac.commons.section", -1);
        formData.addSection(commonSection);
        for (Field field : simpleFields) {
            MetaColumn column = new MetaColumn(field.getType().getName(), field.getName());
            commonSection.addField(column);
            setDefaultWidget(field, column);

            //Case of ManyToOne
            if (field.isAnnotationPresent(ManyToOne.class)) {
                setComplexTypeField(wrapper, field, column);
            }
        }
        //Process List fields
        for (Field field : collectionsFields) {
            SectionData sectionData = new SectionData(field.getName(), field.getName(), 1);
            formData.addSection(sectionData);
            Class<?> elementType = getCollectionDeclaredType(field);
            MetaColumn column = new MetaColumn(elementType.getName(), field.getName());
            sectionData.addField(column);
            setDefaultWidget(field, column);
            setComplexTypeField(wrapper, field, column);
        }

    }

    private static Class<?> getCollectionDeclaredType(Field field) {
       // System.out.println("Field name : "+field.getName());
        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Class<?> elementType = (Class<?>) type.getActualTypeArguments()[0];
        return elementType;
    }

    /**
     *
     * @param metaData
     * @param fields
     */
    private void buildListView(PluginWrapper wrapper, Class clazz, MetaData metaData, List<Field> fields, boolean principal) throws JAXBException {
        final ListViewData listViewData = metaData.getListView();

        List<Field> managedFields = fields.stream().filter(field -> !Collection.class.isAssignableFrom(field.getType()))
                .collect(Collectors.toUnmodifiableList());

        for (Field field : managedFields) {
            MetaColumn column = new MetaColumn(field.getType().getName(), field.getName());
            SearchColumn searchColumn = new SearchColumn(field.getType().getName(), field.getName(), null);
            listViewData.addColumn(column);
            listViewData.addSearch(searchColumn);
            //TODO Set th field title and description
            setDefaultWidget(field, column);

            if (field.isAnnotationPresent(ManyToOne.class)) {
                setComplexTypeField(wrapper, field, column);
            }
        }
    }

    /**
     *
     * @param template
     * @param meta
     * @param fields
     */
    private void buildEditorArea(PluginWrapper wrapper, Context template, MetaData meta, List<Field> fields, boolean principal) throws JAXBException {
        //Fields use to build Table column
        final List<Field> managedFields = new ArrayList<>();
        Map<String, ColumnType> columnsTypeMap = new HashMap();
        final EditorAreaData editorArea = meta.getEditorarea();

        if (Objects.isNull(template)
            || Objects.isNull(template.getEditorArea())
            ||  Objects.isNull(template.getEditorArea().getComponent())) {//Not editorErea for this template
            return;
        }
        //TODO : add editor title

        EditorArea editor = template.getEditorArea();
        meta.setCanCreate(editor.isCreate());
        meta.setCanUpdate(editor.isUpdate());
        meta.setCanDelete(editor.isDelete());
        meta.setCreateOnField(editor.isCreateOnField());
        meta.setActiveFollower(editor.isFollower());
        meta.setActiveFileLink(editor.isFilelink());
        meta.setSearchKey(editor.getSearchKey());
        //Build Common Form
        FormData commonForm = new FormData();
        editorArea.setForm(commonForm);
        CommonType commonType = editor.getComponent().getCommon();
        if (Objects.nonNull(commonType)) {
            FormType formType = commonType.getForm();
            buildForm(wrapper, commonForm, formType, fields, principal);
        }
        //Process of Tab Component
        if (!CollectionUtils.isEmpty(editor.getComponent().getTab())) {
            for (TabType tabType : editor.getComponent().getTab()) {
                //TODO build tabe type name
                TabData tabData = new TabData(tabType.getName(), tabType.getName());
                editorArea.addTab(tabData);
                buildTab(wrapper, tabData, tabType, fields, principal);
            }
        }
        if (Objects.nonNull(editor.getActions())
          && !CollectionUtils.isEmpty(editor.getActions().getAction())) {
            for (Action action : editor.getActions().getAction()) {
                editorArea.addAction(buildActionData(action));
            }
        }
    }

    /**
     *
     * @param wrapper
     * @param tabData
     * @param tabType
     * @param fields
     */
    private void buildTab(PluginWrapper wrapper, TabData tabData, TabType tabType, List<Field> fields, boolean principal) throws JAXBException {
             FormData formData = new FormData();
             tabData.setForm(formData);
             buildForm(wrapper, formData, tabType.getForm(), fields, principal);
    }

    /**
     * Build Form form FormType
     * @param formData
     * @param formType
     * @param fields
     */
    private void buildForm(PluginWrapper wrapper, FormData formData, FormType formType, List<Field> fields, boolean principal) throws JAXBException {

         for (SectionType sectionType : formType.getSection()) {
             SectionData sectionData = new SectionData(sectionType.getName(), sectionType.getName(), sectionType.getColumns().intValue());
             formData.addSection(sectionData);
             buildSection(wrapper, sectionData, sectionType, fields, principal);
         }
    }

    /**
     * Build Section
     * @param sectionData
     * @param sectionType
     * @param fields
     */
    private void buildSection(PluginWrapper wrapper, SectionData sectionData, SectionType sectionType, List<Field> fields, boolean principal) throws JAXBException {
            buildSubsectionType(wrapper, sectionData, sectionType, fields, principal);

            if (!CollectionUtils.isEmpty(sectionType.getSection())) {
                for (SubSectionType subSectionType : sectionType.getSection()) {
                    SectionData subSectionData = new SectionData(sectionType.getName(), sectionType.getName(), subSectionType.getColumns().intValue());
                    sectionData.addSection(subSectionData);
                    buildSubsectionType(wrapper, subSectionData, subSectionType, fields, principal);
                }
            }
    }

    /**
     *
     * @param sectionData
     * @param sectionType
     * @param fields
     */
    private void buildSubsectionType(PluginWrapper wrapper, SectionData sectionData, SubSectionType sectionType, List<Field> fields, boolean principal) throws JAXBException {
        sectionData.setColumns(sectionType.getColumns().intValue());
        sectionData.setHeader(sectionType.isHeader());
        sectionData.setName(sectionType.getName());
        //TODO : build sectionData title
        Map<String, FieldType> fieldTypeMap = sectionType.getField().stream().collect(Collectors.toMap(FieldType::getQualifier, fieldType -> fieldType));
        final Set<String> managedFieldNames = fieldTypeMap.keySet();
        List<Field> managedFields =  fields.stream().filter(field -> managedFieldNames.contains(field.getName())).collect(Collectors.toUnmodifiableList());
        //System.out.println("buildSubsectionType "+" section name : "+sectionData.getName()+"  : "+managedFields.size());

        for (Field field : managedFields) {
            final MetaColumn column = new MetaColumn(field.getType().getName(), field.getName());

            if(Collection.class.isAssignableFrom(field.getType()))
                column.setType(getCollectionDeclaredType(field).getName());

            sectionData.addField(column);
            setDefaultWidget(field, column);
            FieldType fieldType = fieldTypeMap.get(field.getName());
            column.setSequence((short) fieldType.getPosition());
            if (Objects.nonNull(fieldType.getWidget())) {
                column.setWidget(fieldType.getWidget().value());
            }
            column.setEditable(fieldType.isEditable());
            column.setUpdatable(fieldType.isUpdatable());
            column.setDeletable(fieldType.isDeletable());
            column.setObservable(fieldType.isObservable());
            column.setObserve(fieldType.getObserve());
            column.setHandler(fieldType.getHandler());

            //Gestion des actions
            if (Objects.nonNull(fieldType.getActions())
                && !CollectionUtils.isEmpty(fieldType.getActions().getAction())) {
                    for (Action action : fieldType.getActions().getAction()) {
                        ActionData actionData = buildActionData(action);
                        column.addAction(actionData);
                    }
            }
            if (principal) {//This is done just for the principal
                if (field.isAnnotationPresent(ManyToOne.class)
                        || field.isAnnotationPresent(OneToMany.class)
                        || field.isAnnotationPresent(ManyToMany.class)
                        || field.isAnnotationPresent(OneToOne.class)) {
                    setComplexTypeField(wrapper, field, column);
                }
            }
        }
    }

    /***
     *
     * @param action
     * @return
     */
    private static ActionData buildActionData(Action action) {
        ActionData actionData = new ActionData(action.getName(), action.getCode(), action.getIcon());
        actionData.setType(action.getType());
        if (Objects.nonNull(action.getBadgeColor()))
          actionData.setBadgeColor(action.getBadgeColor().value());

        actionData.setCounter(action.getCounter());
        actionData.setDynamic(action.isDynamic());
        actionData.setModal(action.isModal());
        actionData.setRedirect(action.isRedirect());

        if (Objects.nonNull(action.getTypeOp()))
           actionData.setTypeOp(action.getTypeOp().value());
        if (Objects.nonNull(action.getPosition()))
           actionData.setPosition(action.getPosition().value());
        return actionData;
    }

    /**
     * @param template
     * @param meta
     * @param fields
     */
    private void buildListView(PluginWrapper wrapper, Context template, MetaData meta, List<Field> fields) throws JAXBException {
        //Fields use to build Table column
        final List<Field> managedFields = new ArrayList<>();
        Map<String, ColumnType> columnsTypeMap = new HashMap();
        Map<String, SearchField> searchColumnMap = new HashMap();

        //If template is define the template config take the lead
        if (Objects.isNull(template)
                ||Objects.isNull(template.getListView())
                || Objects.isNull(template.getListView().getList())
                || CollectionUtils.isEmpty(template.getListView().getList().getColumn())) {
            return; //No ListView for this metadata
        }
        //Build the list of template column
        columnsTypeMap = template.getListView().getList().getColumn().stream().collect(Collectors.toMap(ColumnType::getQualifier,
                columnType -> columnType));

        if (Objects.nonNull(template.getListView().getSearch())
            && !CollectionUtils.isEmpty(template.getListView().getSearch().getField())) {
            searchColumnMap = template.getListView().getSearch().getField().stream().collect(Collectors.toMap(SearchField::getName, val -> val));
        }

        final Set<String> columnsTypeNameKeys = columnsTypeMap.keySet();
        managedFields.addAll(fields.stream().filter(field -> columnsTypeNameKeys.contains(field.getName())).collect(Collectors.toUnmodifiableList()));
        ListViewData listView = meta.getListView();
        //TODO : Set ListEditor Title

        //managedColumns contains ListView Columns or class columns
        for (Field field : managedFields) {
            MetaColumn column = buildListColumn(field, columnsTypeMap);
            listView.addColumn(column);

            if (column.getSearch()) {
                listView.addSearch(buildSearchField(field));
            }
            if (field.isAnnotationPresent(ManyToOne.class)) {
                setComplexTypeField(wrapper, field, column);
            }

        }

        //Build Action List
        if (Objects.nonNull(template.getListView().getActions())
              && !CollectionUtils.isEmpty(template.getListView().getActions().getAction())) {
            for (Action action : template.getListView().getActions().getAction()) {
                listView.addAction(buildActionData(action));
            }
        }

    }

    /**
     *
     * @param wrapper
     * @param field
     * @param column
     * @throws JAXBException
     */
    private void setComplexTypeField(PluginWrapper wrapper, Field field, MetaColumn column) throws JAXBException {

        Class fieldClass = field.getType();

        if (Collection.class.isAssignableFrom(fieldClass))
            fieldClass = getCollectionDeclaredType(field);

        WCMS wcms = fieldClass.isAnnotationPresent(WCMS.class) ? (WCMS) fieldClass.getAnnotation(WCMS.class) : null;

        String fieldtemplate = Objects.nonNull(wcms) ? wcms.template() : field.getType().getSimpleName();
        String fieldPluginId = Objects.nonNull(wcms) ? wcms.plugin() : null;

        PluginWrapper fieldWrapper = wrapper;
        if (StringUtils.isNotBlank(fieldPluginId)) {
            fieldWrapper = pluginManager.getPlugin(fieldPluginId);
        }
        getWcms result = new getWcms(fieldtemplate, fieldWrapper);
        column.setMeta(buildMetaDataFrom(field.getType(), result.fieldWrapper(), result.templatename().concat(".xml"), false));
    }

    /**
     * Record which map wrapper and templatename
     * @param templatename
     * @param fieldWrapper
     */
    private record getWcms(String templatename, PluginWrapper fieldWrapper) {
    }

    /**
     *
     * @return
     */
    private SearchColumn buildSearchField(Field field) {
        SearchColumn column = new SearchColumn(field.getType().getName(), field.getName(),null);
        return column;
    }

    /**
     *
     * @param field
     * @param columnsTypeMap
     * @return
     */
    private static MetaColumn buildListColumn(Field field, Map<String, ColumnType> columnsTypeMap) {
        MetaColumn column = new MetaColumn(field.getType().getName(), field.getName());
        setDefaultWidget(field, column);

        if (columnsTypeMap.containsKey(field.getName())) {//Use the template declaration
            ColumnType columnType = columnsTypeMap.get(field.getName());

            if (Objects.nonNull(columnType.getWidget())) {
                column.setWidget(columnType.getWidget().value());
            }
            column.setSearch(columnType.isSearch());
            column.setSequence((short) columnType.getPosition());
            column.setEditable(columnType.isEditable());
            column.setUpdatable(columnType.isUpdatable());
            column.setShow(columnType.isShow());

            if (Objects.nonNull(columnType.getPattern()) && CollectionUtils.isEmpty(columnType.getPattern().getField())) {
                PatternData pattern = new PatternData(columnType.getPattern().getSeparator(), columnType.getPattern().getField().stream()
                        .map(patternField -> patternField.getName()).collect(Collectors.toUnmodifiableList()));
                column.setPattern(pattern);
            }
        }
        return column;
    }

    /**
     *
     * @param field
     * @param column
     */
    private static void setDefaultWidget(Field field, MetaColumn column) {
        //Set defalt Many to one widget
        if (field.isAnnotationPresent(ManyToOne.class)) {
            column.setWidget("manytoone");
        }
        if (field.isAnnotationPresent(OneToMany.class)) {
            column.setWidget("onetomany");
        }
        if (field.isAnnotationPresent(ManyToMany.class)) {
            column.setWidget("manytomany");
        }
        if (field.getType().isAssignableFrom(Number.class))
            column.setWidget("number");
        else if (field.getType().isAssignableFrom(String.class))
            column.setWidget("text");
        else if (field.getType().isAssignableFrom(Date.class))
            column.setWidget("date");
    }


    /**
     *
     * @param clazz
     * @return  All declared fields for clazz and all it direct and undirect parent
     */
    private static List<Field> getDeclaredFieldsFrom(Class clazz) {
        List<Field> fields = new ArrayList<>();
        Class currentClass = clazz;
        while (!Object.class.equals(currentClass)) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            for (Field field : declaredFields) {
                fields.add(field);
            }
            currentClass = currentClass.getSuperclass();
        }
        return fields;
    }
}
