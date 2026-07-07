---Create the default action
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat)
VALUES ('defaultAction', 'Action par défaut', 'defaultAction', null, null, NOW());
---PluginAction
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat)
VALUES ('pluginAction', 'Action permettant effectuer des actions sur un plugin', 'pluginAction', null, null, NOW());
----cronJobAction
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat)
VALUES ('cronJobAction', 'Action gerant les opérations sur le cronJob', 'cronJobAction', null, null, NOW());
----Ccron_state
INSERT INTO cron_state (code, description, createdat)
VALUES ('CREATE', 'Crée', NOW());
INSERT INTO cron_state (code, description, createdat)
VALUES ('UNKNOWN', 'Inconnu', NOW());
INSERT INTO cron_state (code, description, createdat)
VALUES ('RUNNING', 'En cours', NOW());
INSERT INTO cron_state (code, description, createdat)
VALUES ('PAUSED', 'En Arrêt', NOW());
INSERT INTO cron_state (code, description, createdat)
VALUES ('ABORTED', 'Interrompu', NOW());
INSERT INTO cron_state (code, description, createdat)
VALUES ('FINISHED', 'Terminé', NOW());
------Update cron_result --------
INSERT INTO cron_result (code, description, createdat)
VALUES ('ERROR', 'En erreur', NOW());
INSERT INTO cron_result (code, description, createdat)
VALUES ('FAILURE', 'En échec', NOW());
INSERT INTO cron_result (code, description, createdat)
VALUES ('SUCCESS', 'Succès', NOW());
INSERT INTO cron_result (code, description, createdat)
VALUES ('UNKNOWN', 'Indeterminé', NOW());