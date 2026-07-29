---Create the default action
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat,stringvalue)
VALUES ('defaultAction', 'Action par défaut', 'defaultAction', null, null, NOW(), 'defaultAction');
---PluginAction
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat,stringvalue)
VALUES ('pluginAction', 'Action permettant effectuer des actions sur un plugin', 'pluginAction', null, null, NOW(), 'pluginAction');
----cronJobAction
INSERT INTO cms_action (code, descrip, bean, plugin_id, plugin_version, createdat,stringvalue)
VALUES ('cronJobAction', 'Action gerant les opérations sur le cronJob', 'cronJobAction', null, null, NOW(), 'cronJobAction');
----Ccron_state
INSERT INTO cron_state (code, description, createdat,stringvalue)
VALUES ('CREATE', 'Nouveau', NOW(), 'Nouveau');
INSERT INTO cron_state (code, description, createdat,stringvalue)
VALUES ('UNKNOWN', 'Inconnu', NOW(), 'Inconnu');
INSERT INTO cron_state (code, description, createdat,stringvalue)
VALUES ('RUNNING', 'En cours', NOW(), 'En cours');
INSERT INTO cron_state (code, description, createdat,stringvalue)
VALUES ('PAUSED', 'En Arrêt', NOW(), 'En arrêt');
INSERT INTO cron_state (code, description, createdat,stringvalue)
VALUES ('ABORTED', 'Interrompu', NOW(), 'Interrompu');
INSERT INTO cron_state (code, description, createdat,stringvalue)
VALUES ('FINISHED', 'Terminé', NOW(), 'Terminé');
------Update cron_result --------
INSERT INTO cron_result (code, description, createdat, stringvalue)
VALUES ('ERROR', 'En erreur', NOW(), 'En Erreur');
INSERT INTO cron_result (code, description, createdat, stringvalue)
VALUES ('FAILURE', 'En échec', NOW(), 'En Echec');
INSERT INTO cron_result (code, description, createdat, stringvalue)
VALUES ('SUCCESS', 'Succès', NOW(), 'Succès');
INSERT INTO cron_result (code, description, createdat, stringvalue)
VALUES ('UNKNOWN', 'Indeterminé', NOW(), 'Indeterminé');
----Update adm_plugin_category --------------
INSERT INTO adm_plugin_category (code, title, createdat, stringvalue)
VALUES ('sales', 'Ventes', NOW(), 'Ventes');
INSERT INTO adm_plugin_category (code, title, createdat, stringvalue)
VALUES ('purchase', 'Achats', NOW(), 'Achats');
INSERT INTO adm_plugin_category (code, title, createdat, stringvalue)
VALUES ('system', 'Administration', NOW(), 'Administration');
INSERT INTO adm_plugin_category (code, title, createdat, stringvalue)
VALUES ('operations', 'Opérations & Logistique', NOW(), 'Opérations & Logistique');
INSERT INTO adm_plugin_category (code, title, createdat, stringvalue)
VALUES ('finance', 'Finances & Factures', NOW(), 'Finances & Factures');
INSERT INTO adm_plugin_category (code, title, createdat, stringvalue)
VALUES ('human_resources', 'Ressource humaines', NOW(), 'Ressource humaines');
------Settings-------------
INSERT INTO adm_settings (key, value, createdat, stringvalue)
VALUES ('PAGE_SIZE', '10', NOW(), 'PAGE_SIZE');
-- Fake Module
INSERT INTO public.adm_plugin(
	id, version, name, icon, color, sequence, autoinstall, summary, description, category, email, website, phone, install, instaldate, createdat, lastmodif)
	VALUES ('crm','1.0.0', 'CRM', 'Briefcase', '#10b981', 10, false, 'Suivi des pistes, opportunités et prévisions de ventes.', 'Suivi des pistes, opportunités et prévisions de ventes.', 'sales', 'teratech@gmmail.com', 'www.teratech.cm', null, true, now(), now (), null);
INSERT INTO public.adm_plugin(
	id, version, name, icon, color, sequence, autoinstall, summary, description, category, email, website, phone, install, instaldate, createdat, lastmodif)
	VALUES ('sales','1.0.0', 'Ventes', 'ShoppingCart', '#2563eb', 10, false, 'Création de devis, factures proforma et contrats clients.', 'Création de devis, factures proforma et contrats clients.', 'sales', 'teratech@gmmail.com', 'www.teratech.cm', null, true, now(), now (), null);
INSERT INTO public.adm_plugin(
	id, version, name, icon, color, sequence, autoinstall, summary, description, category, email, website, phone, install, instaldate, createdat, lastmodif)
	VALUES ('inventory','1.0.0', 'Inventaire', 'Package', '#f59e0b', 10, false, 'Gestion des stocks en double entrée et traçabilité.', 'Gestion des stocks en double entrée et traçabilité.', 'operations', 'teratech@gmmail.com', 'www.teratech.cm', null, true, now(), now (), null);
INSERT INTO public.adm_plugin(
	id, version, name, icon, color, sequence, autoinstall, summary, description, category, email, website, phone, install, instaldate, createdat, lastmodif)
	VALUES ('accounting','1.0.0', 'Comptabilité', 'BarChart3', '#dc2626', 10, false, 'Suivi bancaire, bilans et rapports financiers automatisés.', 'Suivi bancaire, bilans et rapports financiers automatisés.', 'finance', 'teratech@gmmail.com', 'www.teratech.cm', null, true, now(), now (), null);
INSERT INTO public.adm_plugin(
	id, version, name, icon, color, sequence, autoinstall, summary, description, category, email, website, phone, install, instaldate, createdat, lastmodif)
	VALUES ('hr','1.0.0', 'Employés / RH', 'Users', '#7c3aed', 10, false, 'Gestion des contrats, présences et fiches de paie.', 'Gestion des contrats, présences et fiches de paie.', 'human_resources', 'teratech@gmmail.com', 'www.teratech.cm', null, true, now(), now (), null);
INSERT INTO public.adm_plugin(
	id, version, name, icon, color, sequence, autoinstall, summary, description, category, email, website, phone, install, instaldate, createdat, lastmodif)
	VALUES ('invoicing','1.0.0', 'Facturation', 'FileText', '#06b6d4', 10, false, 'Édition de factures clients et suivi des paiements.', 'Édition de factures clients et suivi des paiements.', 'finance', 'teratech@gmmail.com', 'www.teratech.cm', null, true, now(), now (), null);
INSERT INTO public.adm_plugin(
	id, version, name, icon, color, sequence, autoinstall, summary, description, category, email, website, phone, install, instaldate, createdat, lastmodif)
	VALUES ('purchase','1.0.0', 'Achats', 'Truck', '#ea580c', 10, false, 'Gestion des appels offres et commandes fournisseurs.', 'Gestion des appels offres et commandes fournisseurs.', 'operations', 'teratech@gmmail.com', 'www.teratech.cm', null, true, now(), now (), null);
-----Fake MetaType
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Plugin', 'com.teratech.model.PluginModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('PluginCategory', 'com.teratech.model.PluginCategoryModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Business', 'com.teratech.model.security.BusinessModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('BusinessContact', 'com.teratech.model.security.BusinessContactModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('User', 'com.teratech.model.security.UserModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('UserRigth', 'com.teratech.model.security.UserRigthModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('UserGroup', 'com.teratech.model.security.UserGroupModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('BusinessRule', 'com.teratech.model.rules.BusinessRuleModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Catalog', 'com.teratech.model.media.CatalogModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Version', 'com.teratech.model.media.VersionModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('CronJob', 'com.teratech.model.jobs.CronJobModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('CronJobResult', 'com.teratech.model.jobs.CronJobResultModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('CronJobState', 'com.teratech.model.jobs.CronJobStateModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Local', 'com.teratech.model.i18n.LocalModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Menu', 'com.teratech.model.cms.MenuModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('MenuItem', 'com.teratech.model.cms.MenuItemModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Action', 'com.teratech.model.cms.ActionModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('MetaType', 'com.teratech.model.cms.MetaTypeModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('PageTemplate', 'com.teratech.model.cms.PageTemplateModel', true, '', 'backoffice', '1.0.0', now());
INSERT INTO cms_metatype (code, class_name, concrete, descrip, plugin_id, plugin_version, createdat)
VALUES ('Settings', 'com.teratech.model.settings.SettingsModel', true, '', 'backoffice', '1.0.0', now());
