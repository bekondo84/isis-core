---Create the default action
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createAt)
VALUES ("defaultAction", "Action par défaut", "defaultAction", null, null, NOW());