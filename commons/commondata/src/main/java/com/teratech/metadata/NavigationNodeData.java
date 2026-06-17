package com.teratech.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NavigationNodeData extends NavigationComponentData{

    private List<NavigationComponentData> navigations = new ArrayList<>();

    public NavigationNodeData() {

    }

    public List<NavigationComponentData> getNavigations() {
        return Collections.unmodifiableList(navigations);
    }

    public void setNavigations(List<NavigationComponentData> navigations) {
        this.navigations = navigations;
    }

    public void add(NavigationComponentData node){
        this.navigations.add(node);
    }

    public  void  remove(NavigationComponentData node) {
       int index = -1 ;
       for (int i = 0 ; i < getNavigations().size(); i++) {
             if (getNavigations().get(i).getCode().equalsIgnoreCase(node.getCode())){
                 index = i ;
                 break;
             }
       }
       if (index >= 0) {
           navigations.remove(index);
       }
    }

}
