---Create the default action
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat)
VALUES ('defaultAction', 'Action par défaut', 'defaultAction', null, null, NOW());
---PluginAction
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat)
VALUES ('pluginAction', 'Action permettant effectuer des actions sur un plugin', 'pluginAction', 'backoffice', '1.0.0', NOW());