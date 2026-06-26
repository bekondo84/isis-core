package com.teratech.model.cms;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MENU")
public class MenuModel extends AbstractMenu {


}
