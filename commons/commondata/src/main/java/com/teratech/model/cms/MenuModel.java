package com.teratech.model.cms;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MENU")
public class MenuModel extends AbstractMenu {


}
