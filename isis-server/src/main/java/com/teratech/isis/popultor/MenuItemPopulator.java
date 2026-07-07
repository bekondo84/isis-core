package com.teratech.isis.popultor;

import com.teratech.metadata.MenuItemData;
import com.teratech.model.cms.MenuItemModel;
import com.teratech.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuItemPopulator implements Populator<MenuItemModel, MenuItemData> {

    @Autowired
    private AbstractMenuPopulator menuPopulator;

    /**
     * @param source
     * @param target
     * @throws Exception
     */
    @Override
    public void populate(MenuItemModel source, MenuItemData target) throws Exception {
           menuPopulator.populate(source, target);
           target.setAction(source.getAction());
           target.setType(source.getType());
           target.setViewMode(source.getViewType());
           target.setTemplate(source.getTemplate());
           target.setBadgeColor(source.getBadgeColor());
           target.setModal(source.isModal());
    }
}
