package com.teratech.isis.services.impl;

import com.teratech.exceptions.ModelServiceException;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.jaxb.entities.ExplorerTree;
import com.teratech.jaxb.entities.NavigationNode;
import com.teratech.model.PluginModel;
import com.teratech.model.cms.MenuItemModel;
import com.teratech.model.cms.MenuLevel;
import com.teratech.model.cms.MenuModel;
import com.teratech.services.I18NService;
import com.teratech.services.JAXBService;
import com.teratech.services.MenuNodeService;
import com.teratech.services.impl.JAXBServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Service
public class MenuNodeServiceImpl implements MenuNodeService {

    private final FlexibleSearch flexibleSearch;
    private final PluginManager pluginManager;
    private final JAXBService jaxbService = new JAXBServiceImpl();
    private final I18NService i18NService;
    private final PersistenceManager persistenceManager;

    /**
     *
     * @param flexibleSearch
     * @param pluginManager
     */
    public MenuNodeServiceImpl(FlexibleSearch flexibleSearch, PluginManager pluginManager, I18NService i18NService, PersistenceManager persistenceManager) {
        this.flexibleSearch = flexibleSearch;
        this.pluginManager = pluginManager;
        this.i18NService = i18NService;
        this.persistenceManager = persistenceManager;
    }

    /**
     * @param wrapper
     */
    @Override
    public void cleanPluginMenus(PluginWrapper wrapper) {
        //clean all previous nodes link to this plugin
        Map<String, Object> parameters = new HashMap<>() {{
            put("plugin", wrapper.getPluginId());
            put("version", wrapper.getDescriptor().getVersion());
        }};
        //Reset Menu Parent relation
        persistenceManager.executeUpdate(RESET_MENU_PARENT_QUERY, parameters);
        //Delete All menu of the plugin
        persistenceManager.executeUpdate(DELETE_MENU_QUERY, parameters);
    }

    /**
     * Build plugin navigation nodes
     *
     * @param wrapper
     * @return
     */
    @Override
    public void buildMenus(PluginWrapper wrapper) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, JAXBException, ModelServiceException {

        final PluginModel plugin = flexibleSearch.find(new PluginModel(wrapper.getPluginId(), wrapper.getDescriptor().getVersion()));

        if (Objects.isNull(plugin)) {
            throw new IllegalStateException(String.format("No plugin with ID %s and version %s is record in the dataset", wrapper.getPluginId(), plugin.getVersion()));
        }

        ExplorerTree explorer = jaxbService.getExplorerFromResources(wrapper);

        if (Objects.isNull(explorer))//Case of plugin without menu
            return ;

        //Delete plugin menus
        cleanPluginMenus(wrapper);
        //Build menus of the plugin
       buildMenus (explorer, plugin, wrapper);
    }

    /**
     *
     * @param explorer
     * @param plugin
     * @param wrapper
     * @throws ModelServiceException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void buildMenus(ExplorerTree explorer, PluginModel plugin, PluginWrapper wrapper) throws ModelServiceException, NoSuchFieldException, IllegalAccessException {

           for (NavigationNode navNode : explorer.getNavigationNode()) {
                buildMenus(navNode, null, plugin, MenuLevel.LEVEL_1, wrapper);
           }
    }

    /**
     *
     * @param node
     * @param parent
     * @param plugin
     * @param level
     * @param wrapper
     * @throws ModelServiceException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void buildMenus(NavigationNode node, MenuModel parent, PluginModel plugin, MenuLevel level, PluginWrapper wrapper) throws ModelServiceException, NoSuchFieldException, IllegalAccessException {
        assert Objects.nonNull(node): String.format("navigation node is null");

        //Malforme node Menu must have child
        if (StringUtils.isBlank(node.getCode())
          && CollectionUtils.isEmpty(node.getNavigationNode()))
            return;
        //Malforme node MenuItem don't have child
        if (StringUtils.isNotBlank(node.getCode())
          && !CollectionUtils.isEmpty(node.getNavigationNode()))
            return;
        if (!CollectionUtils.isEmpty(node.getNavigationNode())) {//Case of Menu node
            MenuModel menu = new MenuModel();
            menu.setCode(node.getId());
            menu.setIcon(node.getIcon());
            menu.setParent(parent);
            menu.setPlugin(plugin);
            menu.setPosition(node.getPosition());
            menu.setLevel(level);
            menu.setLabel(i18NService.getMessage(wrapper, node.getId()));
            MenuModel currentMenu = persistenceManager.save(menu);

            for (NavigationNode child : node.getNavigationNode()) {
                buildMenus(child, currentMenu, plugin, nextLevel(level), wrapper);
            }
        } else { //Case of MenuItem node
            MenuItemModel menuItem = new MenuItemModel(node.getId());
            menuItem.setType(node.getCode());
            menuItem.setParent(parent);
            menuItem.setAction(node.getAction());
            menuItem.setPosition(node.getPosition());
            menuItem.setViewType(node.getViewMode());
            menuItem.setPlugin(plugin);
            menuItem.setModal(node.isModal());
            menuItem.setIcon(node.getIcon());
            menuItem.setLevel(level);
            if (Objects.nonNull(node.getBadgeColor()))
              menuItem.setBadgeColor(node.getBadgeColor().value());
            menuItem.setLabel(i18NService.getMessage(wrapper, node.getId()));
            persistenceManager.save(menuItem);
        }
    }

    private MenuLevel nextLevel(MenuLevel level) {

        if (level.equals(MenuLevel.LEVEL_1))
           return MenuLevel.LEVEL_2;
        else if (level.equals(MenuLevel.LEVEL_2))
            return MenuLevel.LEVEL_3;
        else if (level.equals(MenuLevel.LEVEL_3))
            return MenuLevel.LEVEL_4;
        return MenuLevel.LEVEL_4;
    }
}
