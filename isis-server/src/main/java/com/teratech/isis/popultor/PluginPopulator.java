package com.teratech.isis.popultor;

import com.teratech.beans.PluginData;
import com.teratech.dao.FlexibleSearch;
import com.teratech.metadata.AbstractMenuData;
import com.teratech.metadata.MenuData;
import com.teratech.metadata.MenuItemData;
import com.teratech.model.PluginModel;
import com.teratech.model.cms.AbstractMenu;
import com.teratech.model.cms.MenuItemModel;
import com.teratech.model.cms.MenuLevel;
import com.teratech.model.cms.MenuModel;
import com.teratech.populator.Populator;
import com.teratech.tools.persistence.RestrictionsContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PluginPopulator implements Populator<PluginModel, PluginData> {

    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private AbstractMenuPopulator menuPopulator;
    @Autowired
    private MenuItemPopulator menuItemPopulator;


    /**
     * @param source
     * @param target
     */
    @Override
    public void populate(PluginModel source, PluginData target) throws Exception {
         target.setId(source.getId());
         target.setVersion(source.getVersion());
         target.setName(source.getName());
         target.setSequence(source.getSequence());
         target.setAutoInstall(source.isAutoInstall());
         target.setSummary(source.getSummary());
         target.setDescription(source.getDescription());
         target.setCategory(source.getCategory());
         target.setEmail(source.getEmail());
         target.setWebsite(source.getWebsite());
         target.setPhone(source.getPhone());
         target.setInstall(source.isInstall());
         target.setInstaldate(source.getInstaldate());

         //Build navigation Node
        buildMenus (target);
    }

    /**
     *
     * @param target
     */
    private void buildMenus(PluginData target) throws Exception {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("plugin.id", target.getId());
        container.addEq("plugin.version", target.getVersion());
        //container.addEq("level", MenuLevel.LEVEL_1);
        List<AbstractMenu> menus = flexibleSearch.doSearch(AbstractMenu.class, container, new HashMap<>(), new HashSet<>(), 0, -1);
        final Map<String, AbstractMenuData> menuMap = new HashMap<>();
        //Build Level 1 Node
        buildMenusForLevel(target, menus,  menuMap, MenuLevel.LEVEL_1);
        //Build level 2 menus
        buildMenusForLevel(target, menus, menuMap, MenuLevel.LEVEL_2);
        //Build level 3 menus
        buildMenusForLevel(target, menus, menuMap, MenuLevel.LEVEL_3);
        //Build level 4 menus
        buildMenusForLevel(target, menus, menuMap, MenuLevel.LEVEL_4);
        //Build level 5 menus
        buildMenusForLevel(target, menus, menuMap, MenuLevel.LEVEL_5);
    }

    /**
     * Build Level menus
     * @param menus
     * @param menuMap
     * @param menuLevel
     */
    private void buildMenusForLevel(PluginData plugin, List<AbstractMenu> menus, Map<String, AbstractMenuData> menuMap, MenuLevel menuLevel) throws Exception {
        //Extract and sort Menu Level
        List<AbstractMenu> levelMenus = menus.stream().filter(menu -> menu.getLevel().equals(menuLevel))
                .sorted(new Comparator<AbstractMenu>() {
                    @Override
                    public int compare(AbstractMenu menu1, AbstractMenu menu2) {
                        return Integer.compare(menu1.getPosition(), menu2.getPosition());
                    }
                }).collect(Collectors.toUnmodifiableList());

        for (AbstractMenu menu : levelMenus) {
            AbstractMenuData menuData = null ;
             if (menu instanceof MenuModel) {
                 menuData = new MenuData();
                 menuPopulator.populate(menu, menuData);
             }
             else {
                 menuData = new MenuItemData();
                 menuItemPopulator.populate((MenuItemModel) menu, (MenuItemData) menuData);
             }
             //Ajout du menu dans la base de connaissance
             menuMap.put(menu.getCode(), menuData);

             if (menuLevel.equals(MenuLevel.LEVEL_1)) {//Si menu de type Level 1 ajout dans les menus racine du plugin
                 plugin.addMenu(menuData);
             } else {//Men de niveau superieur à 1, ajout au parent
                 if (Objects.nonNull(menu.getParent()))
                    ((MenuData)menuMap.get(menu.getParent().getCode())).add(menuData);
             }
        }
    }
}


