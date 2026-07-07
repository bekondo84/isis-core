  ---Create table catalog --
  CREATE TABLE IF NOT EXISTS adm_catalog (
      id VARCHAR(50),
      name VARCHAR(255),
      createdAt TIMESTAMPTZ NOT NULL,
      lastModif TIMESTAMPTZ,
      CONSTRAINT adm_catalog_pk PRIMARY KEY (id)
  );
  ---Create table adm_version----
  CREATE TABLE IF NOT EXISTS adm_version (
     id VARCHAR(50),
     name VARCHAR(255),
     createdAt TIMESTAMPTZ NOT NULL,
     lastModif TIMESTAMPTZ,
     CONSTRAINT adm_version_pk PRIMARY KEY (id)
  );
  ----Create table adm_catalogversion ---
  CREATE TABLE IF NOT EXISTS adm_catalogversion (
      catalogid  VARCHAR(50) NOT NULL,
      versionid VARCHAR(50) NOT NULL,
      createdAt TIMESTAMPTZ NOT NULL,
      lastModif TIMESTAMPTZ,
      CONSTRAINT adm_catalogversion_pk PRIMARY KEY (catalogid, versionid),
      CONSTRAINT fk_adm_catalogversion_on_am_catalog FOREIGN KEY (catalogid) REFERENCES adm_catalog (id) ON DELETE CASCADE,
      CONSTRAINT fk_adm_catalogversion_on_am_version FOREIGN KEY (versionid) REFERENCES adm_version (id) ON DELETE CASCADE
  );
  ----Create adm_media table ---
  CREATE TABLE IF NOT EXISTS adm_media (
     id VARCHAR(50),
     url VARCHAR (255),
     format VARCHAR (4),
     confidential BOOLEAN DEFAULT 'true',
     width SMALLINT,
     height SMALLINT,
     catalogid VARCHAR (50),
     versionid VARCHAR (50),
     createdAt TIMESTAMPTZ NOT NULL,
     lastModif TIMESTAMPTZ,
     CONSTRAINT adm_media_pk PRIMARY KEY (id),
     CONSTRAINT fk_am_media_on_catalog_version FOREIGN KEY (catalogid, versionid)
       REFERENCES adm_catalogversion(catalogid, versionid) ON DELETE CASCADE
  );
-- Create Plugin Table -----
CREATE TABLE IF NOT EXISTS  adm_plugin (
   id VARCHAR(255) NOT NULL,
   version VARCHAR(30) NOT NULL,
   name VARCHAR(255),
   sequence SMALLINT,
   autoinstall BOOLEAN DEFAULT 'false',
   summary VARCHAR(255),
   description TEXT,
   category VARCHAR (50),
   email VARCHAR(80),
   website VARCHAR(255),
   phone VARCHAR(50),
   install BOOLEAN DEFAULT 'false',
   instaldate TIMESTAMPTZ,
   createdAt TIMESTAMPTZ NOT NULL,
   lastModif TIMESTAMPTZ,
   PRIMARY KEY (id, version)
  );
  ---- Table collection of plugins dependencies
  CREATE TABLE IF NOT EXISTS adm_plugin_depend (
        plugin_id VARCHAR (255) NOT NULL,
        plugin_version VARCHAR (30) NOT NULL,
        name VARCHAR (255) NOT NULL,
        ----Primary key definition
        CONSTRAINT pk_plugin_dependencies PRIMARY KEY (plugin_id, plugin_version, name),
        ---FOREIGN KEY with delete on cascade
        CONSTRAINT fk_plugin_depend_on_plugin
        FOREIGN KEY (plugin_id, plugin_version)
        REFERENCES adm_plugin(id, version)
        ON DELETE CASCADE
  );
  ----Table plugin media relation
  CREATE TABLE IF NOT EXISTS adm_plugin_media (
       plugin_id VARCHAR (255) NOT NULL,
       plugin_version VARCHAR (30) NOT NULL,
       media_id VARCHAR (50) NOT NULL,

       CONSTRAINT pk_plugin_media PRIMARY KEY (plugin_id, plugin_version, media_id),
       CONSTRAINT fk_plugin_media_on_plugin FOREIGN KEY (plugin_id, plugin_version)
       REFERENCES adm_plugin(id, version) ON DELETE CASCADE,
       CONSTRAINT fk_plugin_depend_on_media
       FOREIGN KEY (media_id) REFERENCES adm_media (id) ON DELETE CASCADE
  );
-----Create Template page
CREATE TABLE IF NOT EXISTS cms_page_template (
    code VARCHAR (100) NOT NULL,
    description VARCHAR (255),
    plugin_id VARCHAR (255) NOT NULL,
    plugin_version VARCHAR(30) NOT NULL,
    createdAt TIMESTAMPTZ NOT NULL,
    lastModif TIMESTAMPTZ,
    CONSTRAINT pk_cms_page_template PRIMARY KEY (code) ,
    CONSTRAINT fk_cms_page_template_on_adm_plugin FOREIGN KEY (plugin_id, plugin_version)
      REFERENCES adm_plugin (id, version) ON DELETE CASCADE
);
-----Action ------------
CREATE TABLE IF NOT EXISTS cms_action (
    code VARCHAR (50) NOT NULL,
    descrip VARCHAR (255),
    bean VARCHAR (50) NOT NULL,
    plugin_id VARCHAR (50),
    plugin_version VARCHAR (50),
    createdAt TIMESTAMPTZ NOT NULL,
    lastModif TIMESTAMPTZ,

    CONSTRAINT pk_cms_action PRIMARY KEY (code),
    CONSTRAINT fk_cms_action_adm_plugin FOREIGN KEY (plugin_id, plugin_version)
      REFERENCES adm_plugin (id, version) ON DELETE CASCADE
);

----Create table cms_menu
CREATE TABLE IF NOT EXISTS cms_menu (
    code VARCHAR (50) NOT NULL,
    menu_type VARCHAR(50) NOT NULL,
    actif BOOLEAN DEFAULT 'true',
    icon VARCHAR (50),
    label VARCHAR (255) NOT NULL,
    sequence SMALLINT NOT NULL,
    plugin_id VARCHAR (50),
    plugin_version VARCHAR (50),
    parent_id VARCHAR (50),
    menu_level VARCHAR (50) NOT NULL,
    act_name VARCHAR (50),
    type VARCHAR (255),
    view_type VARCHAR (20),
    template VARCHAR (50),
    badge_color VARCHAR (50),
    modal BOOLEAN DEFAULT 'false',
    createdAt TIMESTAMPTZ NOT NULL,
    lastModif TIMESTAMPTZ,

    CONSTRAINT pk_cms_menuitem PRIMARY KEY (code),
    CONSTRAINT fk_csm_menu_adm_plugin FOREIGN KEY (plugin_id, plugin_version)
      REFERENCES adm_plugin (id, version),
    CONSTRAINT fk_cms_menu_cms_menu FOREIGN KEY (parent_id)
     REFERENCES cms_menu (code)
);
------CREATE cms_metatype
CREATE TABLE IF NOT EXISTS cms_metatype (
   code VARCHAR (50) NOT NULL,
   class_name VARCHAR (255) NOT NULL,
   concrete BOOLEAN DEFAULT 'true',
   template VARCHAR (255),
   descrip VARCHAR (255),
   plugin_id VARCHAR (50),
   plugin_version VARCHAR (50),
   createdAt TIMESTAMPTZ NOT NULL,
   lastModif TIMESTAMPTZ,

   CONSTRAINT pk_cms_metatype PRIMARY KEY (code),
   CONSTRAINT fk_cms_metatype_on_cms_metatype FOREIGN KEY (plugin_id, plugin_version)
     REFERENCES adm_plugin (id, version) ON DELETE CASCADE
);
------cms_metafield
CREATE TABLE IF NOT EXISTS cms_metafield (
     id SERIAL NOT NULL,
     name VARCHAR (255) NOT NULL,
     class_name VARCHAR (255) NOT NULL,
     persist BOOLEAN DEFAULT 'true',
     default_value VARCHAR (255),
     primary_key BOOLEAN DEFAULT 'false',
     metatype_id VARCHAR (50) NOT NULL,
     createdAt TIMESTAMPTZ NOT NULL,
     lastModif TIMESTAMPTZ,

     CONSTRAINT pk_cms_metafield PRIMARY KEY (id),
     CONSTRAINT fk_cms_metafield_on_cms_metatype FOREIGN KEY (metatype_id)
      REFERENCES cms_metatype (code) ON DELETE CASCADE
);
----Cron Job Section -----------
CREATE TABLE IF NOT EXISTS cron_state (
   code VARCHAR (50) NOT NULL,
   description VARCHAR (255),
   createdAt TIMESTAMPTZ NOT NULL,
   lastModif TIMESTAMPTZ,

   CONSTRAINT pk_cron_state PRIMARY KEY (code)
);
---Cron result ---
CREATE TABLE IF NOT EXISTS cron_result (
   code VARCHAR (50) NOT NULL,
   description VARCHAR (255),
   createdAt TIMESTAMPTZ NOT NULL,
   lastModif TIMESTAMPTZ,

   CONSTRAINT pk_cron_result PRIMARY KEY (code)
);
---Cron job table
CREATE TABLE IF NOT EXISTS cron_job (
   id VARCHAR (50) NOT NULL,
   cron_type VARCHAR (50) NOT NULL,
   description VARCHAR (255) NOT NULL,
   job VARCHAR (255) NOT NULL,
   cron_expression VARCHAR (255) NOT NULL,
   actif BOOLEAN default 'true',
   last_execution TIMESTAMPTZ,
   next_execution TIMESTAMPTZ,
   priority SMALLINT,
   abort BOOLEAN default 'false',
   state VARCHAR (50) NOT NULL,
   result VARCHAR (50) NOT NULL,
   plugin_id VARCHAR (50) NOT NULL,
   plugin_version VARCHAR (50) NOT NULL,
   createdAt TIMESTAMPTZ NOT NULL,
   lastModif TIMESTAMPTZ,

   CONSTRAINT pk_cron_job PRIMARY KEY (id),
   CONSTRAINT fk_cron_job_cron_state FOREIGN KEY (state)
    REFERENCES cron_state (code),
   CONSTRAINT fk_cron_job_cron_result FOREIGN KEY (result)
    REFERENCES cron_result (code),
    CONSTRAINT fk_cron_job_adm_plugin FOREIGN KEY (plugin_id, plugin_version)
    REFERENCES adm_plugin (id, version)
);
---Cron History
CREATE TABLE IF NOT EXISTS cron_history (
    id SERIAL NOT NULL,
    start_at TIMESTAMPTZ NOT NULL,
    end_at TIMESTAMPTZ ,
    message VARCHAR (255),
    status VARCHAR (255),
    cron_id VARCHAR (50) NOT NULL,
    createdAt TIMESTAMPTZ NOT NULL,
    lastModif TIMESTAMPTZ,

    CONSTRAINT pk_cron_history PRIMARY KEY (id),
    CONSTRAINT fk_cron_history_cron_job FOREIGN KEY (cron_id)
      REFERENCES cron_job (id)
);
-----Local ----
CREATE TABLE IF NOT EXISTS bs_local (
    code VARCHAR (10) NOT NULL,
    description VARCHAR (255),
    separatord VARCHAR (2),
    thousand VARCHAR (2),
    dateformat VARCHAR (50),
    timeformat VARCHAR (50),
    createdAt TIMESTAMPTZ NOT NULL,
    lastModif TIMESTAMPTZ,

    CONSTRAINT pk_bs_local PRIMARY KEY (code)
);
-----Business ---------------
CREATE TABLE IF NOT EXISTS bs_entity (
   code VARCHAR (255) NOT NULL,
   email VARCHAR (255)NOT NULL,
   nui VARCHAR (255) NOT NULL,
   logo VARCHAR (255),
   name VARCHAR (255) NOT NULL,
   adress VARCHAR (255),
   city VARCHAR (255),
   postal VARCHAR (255),
   slogan VARCHAR (255),
   website VARCHAR (255),
   phone VARCHAR (255) NOT NULL,
   fax VARCHAR (255),
   createdAt TIMESTAMPTZ NOT NULL,
   lastModif TIMESTAMPTZ,

   CONSTRAINT pk_bs_entity PRIMARY KEY (code),
   CONSTRAINT fk_bs_entity_adm_media FOREIGN KEY (logo)
   REFERENCES adm_media (id)
);
-----BusinessContact ----------
CREATE TABLE IF NOT EXISTS bs_contact (
     id SERIAL NOT NULL,
     name VARCHAR (255) NOT NULL,
     surname VARCHAR (255),
     phone VARCHAR (255) NOT NULL,
     email VARCHAR (255) NOT NULL,
     title VARCHAR (255) NOT NULL,
     business VARCHAR (255) NOT NULL,
     createdAt TIMESTAMPTZ NOT NULL,
     lastModif TIMESTAMPTZ,

     CONSTRAINT pk_bs_contact PRIMARY KEY (id),
     CONSTRAINT fk_bs_contact__entity FOREIGN KEY (business)
      REFERENCES bs_entity (code)
);
-----User -----
CREATE TABLE IF NOT EXISTS bs_user (
   code VARCHAR (255) NOT NULL,
   name VARCHAR (255) NOT NULL,
   surname VARCHAR (255),
   email VARCHAR (255),
   password VARCHAR (255),
   image VARCHAR (50),
   active BOOLEAN default 'true',
   locked BOOLEAN default 'false',
   langue VARCHAR (50),
   token VARCHAR (255),
   createdAt TIMESTAMPTZ NOT NULL,
   lastModif TIMESTAMPTZ,
   business VARCHAR (255),

   CONSTRAINT pk_bs_user PRIMARY KEY (code),
   CONSTRAINT fk_bs_user_adm_media FOREIGN KEY (image)
   REFERENCES adm_media (id),
   CONSTRAINT fk_bs_user_local FOREIGN KEY (langue)
   REFERENCES bs_local (code),
   CONSTRAINT fk_bs_user_entity FOREIGN KEY (business)
   REFERENCES bs_entity (code)
);
----UserGroup ----------------
CREATE TABLE IF NOT EXISTS bs_usergroup (
    plugin_id VARCHAR (50) NOT NULL,
    plugin_version VARCHAR (50) NOT NULL,
    user_code VARCHAR (50) NOT NULL,
    createdAt TIMESTAMPTZ NOT NULL,
    lastModif TIMESTAMPTZ,

    CONSTRAINT pk_bs_usergroup PRIMARY KEY (plugin_id, plugin_version, user_code),
    CONSTRAINT fk_bs_usergroup_plugin FOREIGN KEY (plugin_id, plugin_version)
     REFERENCES adm_plugin (id, version),
    CONSTRAINT fk_bs_usergroup_user FOREIGN KEY (user_code)
     REFERENCES bs_user (code)
);
----UserRigth ------------------
CREATE TABLE IF NOT EXISTS bs_rigth (
    id SERIAL NOT NULL,
    code VARCHAR (255) NOT NULL,
    name VARCHAR (255),
    can_read BOOLEAN default 'false',
    can_write BOOLEAN default 'false',
    can_delete BOOLEAN default 'false',
    createdAt TIMESTAMPTZ NOT NULL,
    lastModif TIMESTAMPTZ,
    plugin_id VARCHAR (50) NOT NULL,
    plugin_version VARCHAR (50) NOT NULL,
    user_code VARCHAR (50) NOT NULL,
    CONSTRAINT pk_bs_rigth PRIMARY KEY (id),
    CONSTRAINT fk_bs_rigth_usergroup FOREIGN KEY (plugin_id, plugin_version, user_code)
    REFERENCES bs_usergroup (plugin_id, plugin_version, user_code)
);
