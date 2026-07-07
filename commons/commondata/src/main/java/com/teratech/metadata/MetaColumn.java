package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MetaColumn implements Serializable {
    //Name of the type 
    protected String type ;
    //Name of field
    protected String fieldName ;
    //Is the field is a search Field
    protected Boolean search = Boolean.FALSE;
    //Test to print as the label of field
    protected String label ;
    //field description
    protected String description;
    //True if the field is mandatory
    protected Boolean mandatory = Boolean.FALSE;
    //if read=true and write=true ==> the field is readable
    protected Boolean editable = Boolean.TRUE;
    //if updatable=false ==> the field is editable just when it is create
    protected Boolean updatable = Boolean.TRUE;
    protected Boolean deletable = Boolean.TRUE;
    //if read==false ==> hide = true
    protected Boolean show = Boolean.TRUE;
    //Widget component associate to this field
    protected String widget ;
    //True is fied is unique
    protected Boolean unique = Boolean.FALSE;
    protected Boolean email = Boolean.FALSE;
    protected int max ;
    protected  int min ;
     protected Boolean observable ;
    protected String observe ;
    protected String handler;
    protected MetaData meta ;
    protected List<ActionData> actions ;
    protected List<EnumTypeData> values ;
    protected PatternData pattern;
    protected List<FilterData> filters ;

    /**
     * Sequence give the position priority the field with lower value appear first
     * this rule is close in a group where the field is member
     */
    protected short sequence = 0 ;


    public MetaColumn() {
        observable = false ;
        this.actions = new ArrayList<>();
        filters = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    /**
     *
     * @param type
     * @param fieldName
     */
    public MetaColumn(String type, String fieldName) {
        this.type = type;
        this.fieldName = fieldName;
        observable = false ;
        this.actions = new ArrayList<>();
        this.values = new ArrayList<>();
        this.filters = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getUpdatable() {
        return updatable;
    }

    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public short getSequence() {
        return sequence;
    }

    public void setSequence(short sequence) {
        this.sequence = sequence;
    }

    public String getWidget() {
        return widget;
    }

    public void setWidget(String widget) {
        this.widget = widget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public PatternData getPattern() {
        return pattern;
    }

    public void setPattern(PatternData pattern) {
        this.pattern = pattern;
    }

    public Boolean getObservable() {
        return observable;
    }

    public void setObservable(Boolean observable) {
        this.observable = observable;
    }

    public String getObserve() {
        return observe;
    }

    public void setObserve(String observe) {
        this.observe = observe;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Boolean getDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public void addAction(final ActionData action) {
        actions.add(action);
    }
    public List<ActionData> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public void setActions(List<ActionData> actions) {
        this.actions = actions;
    }

    public List<EnumTypeData> getValues() {
        return values;
    }

    public void setValues(List<EnumTypeData> values) {
        this.values = values;
    }

    public List<FilterData> getFilters() {
        return Collections.unmodifiableList(filters);
    }

    public void  addFilter(FilterData filter) {
        filters.add(filter);
    }

    public void setFilters(List<FilterData> filters) {
        this.filters = filters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaColumn that = (MetaColumn) o;
        return Objects.equals(type, that.type) && Objects.equals(fieldName, that.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fieldName);
    }

    @Override
    public String toString() {
        return "MetaColumn{" +
                "type='" + type + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", search=" + search +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", mandatory=" + mandatory +
                ", editable=" + editable +
                ", updatable=" + updatable +
                ", hide=" + show +
                ", widget='" + widget + '\'' +
                ", unique=" + unique +
                ", sequence=" + sequence +
                '}';
    }

}
