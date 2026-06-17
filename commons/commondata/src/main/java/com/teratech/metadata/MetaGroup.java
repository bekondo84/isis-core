package com.teratech.metadata;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class MetaGroup extends MetaColumn  implements Serializable {

    private String groupName ;

    private List<MetaColumn> elements ;

    /**
     *
     * @param groupName
     */
    public MetaGroup(String groupName) {
        super(null, null);
        this.groupName = groupName;
        this.elements =  new ArrayList<>();;
    }

    public void add(MetaColumn column){
        assert Objects.nonNull(column):"Column can't be null";
        elements.add(column);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<MetaColumn> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public void setElements(List<MetaColumn> elements) {
        this.elements = elements;
    }
}
