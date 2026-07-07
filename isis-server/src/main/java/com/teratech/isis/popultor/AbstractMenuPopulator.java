package com.teratech.isis.popultor;

import com.teratech.metadata.AbstractMenuData;
import com.teratech.model.cms.AbstractMenu;
import com.teratech.populator.Populator;
import com.teratech.services.I18NService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractMenuPopulator implements Populator<AbstractMenu, AbstractMenuData> {

    @Autowired
    private I18NService i18NService;
    /**
     * @param source
     * @param target
     * @throws Exception
     */
    @Override
    public void populate(AbstractMenu source, AbstractMenuData target) throws Exception {
          target.setCode(source.getCode());
          target.setActivate(source.isActif());
          target.setIcon(source.getIcon());
          target.setLabel(i18NService.getMessage(source.getPlugin().getId(), source.getLabel()));
          target.setPosition(source.getPosition());
    }
}
