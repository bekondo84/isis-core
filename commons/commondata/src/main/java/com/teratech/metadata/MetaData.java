package com.teratech.metadata;

import java.io.Serializable;

/**
 *
 */
public class MetaData implements Serializable {
    protected String module;
    //Action associate
    private String action;
    //Entity name use to calculate the MetaData
    private String  type ;
    //Type code of the Entity in the MetaTypeModel table
    private String typeCode ;
    //Title of the form
    private String formViewTitle ;
    //Title of the List View
    private String listViewTitle;
    //Enable the possibily
    private Boolean createOnField = Boolean.TRUE;
    //Enable creation or update qction if true
    private Boolean canCreate = Boolean.TRUE;
    //Enable delete Action if true
    private Boolean canDelete = Boolean.TRUE;
    //Unable update action if true
    private Boolean canUpdate = Boolean.TRUE;
    //Activate the follower component if true
    private Boolean activeFollower = Boolean.TRUE;
    //Activate the widget of file load in the header
    private Boolean activeFileLink = Boolean.TRUE;
    //if true informe that we need to load this metadata
    private Boolean partial = false;
    private EditorAreaData editorarea;
    private ListViewData listView;
    private KabanViewData kabanView;
    private String searchKey;
    private String searchTitle;


    public MetaData() {

    }

    public MetaData(final String type , final String typeCode) {
        this.type = type ;
        this.typeCode = typeCode;
        this.editorarea = new EditorAreaData();
        this.listView = new ListViewData();
        this.action = "defaultAction";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getFormViewTitle() {
        return formViewTitle;
    }

    public void setFormViewTitle(String formViewTitle) {
        this.formViewTitle = formViewTitle;
    }

    public String getListViewTitle() {
        return listViewTitle;
    }

    public void setListViewTitle(String listViewTitle) {
        this.listViewTitle = listViewTitle;
    }

    public Boolean getCreateOnField() {
        return createOnField;
    }

    public void setCreateOnField(Boolean createOnField) {
        this.createOnField = createOnField;
    }

    public Boolean getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Boolean canCreate) {
        this.canCreate = canCreate;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(Boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public Boolean getActiveFollower() {
        return activeFollower;
    }

    public void setActiveFollower(Boolean activeFollower) {
        this.activeFollower = activeFollower;
    }

    public Boolean getActiveFileLink() {
        return activeFileLink;
    }

    public Boolean getPartial() {
        return partial;
    }

    public void setPartial(Boolean partial) {
        this.partial = partial;
    }

    public void setActiveFileLink(Boolean activeFileLink) {
        this.activeFileLink = activeFileLink;
    }

    public EditorAreaData getEditorarea() {
        return editorarea;
    }

    public void setEditorarea(EditorAreaData editorarea) {
        this.editorarea = editorarea;
    }

    public ListViewData getListView() {
        return listView;
    }

    public void setListView(ListViewData listView) {
        this.listView = listView;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public KabanViewData getKabanView() {
        return kabanView;
    }

    public void setKabanView(KabanViewData kabanView) {
        this.kabanView = kabanView;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }


}
