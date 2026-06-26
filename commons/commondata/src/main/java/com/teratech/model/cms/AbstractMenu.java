package com.teratech.model.cms;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cms_menu")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "menu_type", discriminatorType = DiscriminatorType.STRING)
public class AbstractMenu extends AbstractItem {

    @Id
    private String code;
    private boolean actif;
    private String icon;
    private String label;
    @Column(name = "sequence")
    private int position;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id"),
            @JoinColumn(name = "plugin_version", referencedColumnName = "version")
    })
    private PluginModel plugin;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private MenuModel parent;

    @Column(name = "menu_level")
    @Enumerated(EnumType.STRING)
    private MenuLevel level;

    public AbstractMenu(String code) {
        this.code = code;
    }

    public AbstractMenu() {
    }

    public MenuModel getParent() {
        return parent;
    }

    public void setParent(MenuModel parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public void setPlugin(PluginModel plugin) {
        this.plugin = plugin;
    }

    public MenuLevel getLevel() {
        return level;
    }

    public void setLevel(MenuLevel level) {
        this.level = level;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractMenu that = (AbstractMenu) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return "AbstractMenu{" +
                "code='" + code + '\'' +
                ", actif=" + actif +
                ", icon='" + icon + '\'' +
                ", label='" + label + '\'' +
                ", position=" + position +
                ", plugin=" + plugin +
                ", parent=" + parent +
                '}';
    }
}
