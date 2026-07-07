package com.teratech.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuData extends AbstractMenuData {

    private List<AbstractMenuData> navigations = new ArrayList<>();

    public MenuData() {

    }

    public List<AbstractMenuData> getNavigations() {
        return Collections.unmodifiableList(navigations);
    }

    public void setNavigations(List<AbstractMenuData> navigations) {
        this.navigations = navigations;
    }

    public void add(AbstractMenuData node){
        this.navigations.add(node);
    }

    public  void  remove(AbstractMenuData node) {
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
