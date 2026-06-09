  ---Create table catalog --
  CREATE TABLE IF NOT EXISTS adm_catalog (
      id VARCHAR(50),
      name VARCHAR(255),
      CONSTRAINT adm_catalog_pk PRIMARY KEY (id)
  );
  ---Create table adm_version----
  CREATE TABLE IF NOT EXISTS adm_version (
     id VARCHAR(50),
     name VARCHAR(255),
     CONSTRAINT adm_version_pk PRIMARY KEY (id)
  );
  ----Create table adm_catalogversion ---
  CREATE TABLE IF NOT EXISTS adm_catalogversion (
      catalogid  VARCHAR(50) NOT NULL,
      versionid VARCHAR(50) NOT NULL,
      CONSTRAINT adm_catalogversion_pk PRIMARY KEY (catalogid, versionid),
      CONSTRAINT fk_adm_catalogversion_on_am_catalog FOREIGN KEY (catalogid) REFERENCES adm_catalog (id) ON DELETE CASCADE,
      CONSTRAINT fk_adm_catalogversion_on_am_version FOREIGN KEY (versionid) REFERENCES adm_version (id) ON DELETE CASCADE
  );
  ----Create adm_media table ---
  CREATE TABLE IF NOT EXISTS adm_media (
     id VARCHAR(50),
     url VARCHAR (255),
     format VARCHAR (4),
     width SMALLINT,
     height SMALLINT,
     catalogid VARCHAR (50),
     versionid VARCHAR (50),
     CONSTRAINT adm_media_pk PRIMARY KEY (id),
     CONSTRAINT fk_am_media_on_catalog_version FOREIGN KEY (catalogid, versionid) REFERENCES adm_catalogversion(catalogid, versionid) ON DELETE CASCADE
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
   PRIMARY KEY (id, version)
  );