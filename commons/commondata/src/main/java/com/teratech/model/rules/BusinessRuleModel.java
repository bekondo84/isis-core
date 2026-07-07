package com.teratech.model.rules;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.Objects;

//@Entity
//@Table(name = "bus_rule")
public class BusinessRuleModel extends AbstractItem {

    @Id
    private String code;
    private String description;
    private String group;
    @Lob
    private String rule;
    @Transient
    private String testResult;


    public BusinessRuleModel() {
    }

    /**
     *
     * @param code
     */
    public BusinessRuleModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessRuleModel that = (BusinessRuleModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return code;
    }
}
