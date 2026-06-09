package com.teratech.isis.popultor;

import com.teratech.isis.model.PluginModel;
import com.teratech.jaxb.entities.Plugin;
import com.teratech.populator.Populator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PluginPopulator implements Populator<Plugin, PluginModel> {
    /**
     * @param source
     * @return
     */
    @Override
    public void populate(Plugin source, PluginModel target) {
         assert Objects.nonNull(target) : "Can't populate null target object";
         assert Objects.nonNull(source) : "Populate source can't be null";

         target.setName(source.getName());
         target.setCategory(source.getCategory());
         target.setDescription(source.getDescription());
         if (Objects.nonNull(source.getContact())) {
             target.setEmail(source.getContact().getEmail());
             target.setWebsite(source.getContact().getWebsite());
             target.setPhone(source.getContact().getPhone());
         }
         target.setAutoInstall(source.isAutoInstall());
         target.setSequence(source.getSequence());
    }
}
