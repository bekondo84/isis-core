package com.teratech.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomFilterData implements Serializable {
    private long id;
    private String name;
    private String typeCode;
    private String scope;
    private String type;
    private LocalDate creationDate;
    private List<PredicateData> predicates = new ArrayList<>();


    public CustomFilterData(long id, String name, String typeCode) {
        this.id = id;
        this.name = name;
        this.typeCode = typeCode;
    }

    public CustomFilterData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public List<PredicateData> getPredicates() {
        return Collections.unmodifiableList(predicates) ;
    }

    /**
     *
     * @param predicates
     */
    public void setPredicates(List<PredicateData> predicates) {
        this.predicates = predicates;
    }

    public String getTypeCode() {
        return typeCode;
    }
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     */
    public static class PredicateData implements Serializable {
        private String field;
        private String value;
        private String criteria;

        public PredicateData(String field, String value, String criteria) {
            this.field = field;
        }

        public PredicateData() {
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCriteria() {
            return criteria;
        }

        public void setCriteria(String criteria) {
            this.criteria = criteria;
        }
    }
}
