package com.teratech.isis.config;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class SchemaMultiTenantConnectionProvider implements MultiTenantConnectionProvider<String> {

    private static final Logger log = LoggerFactory.getLogger(SchemaMultiTenantConnectionProvider.class);
    private final DataSource dataSource;

    public SchemaMultiTenantConnectionProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        log.trace("Acquisition de connexion pour le schéma : {}", tenantIdentifier);
        final Connection connection = getAnyConnection();
        try (Statement statement = connection.createStatement()) {
            // Commande PostgreSQL essentielle pour changer le schéma à la volée
            statement.execute("SET search_path TO " + tenantIdentifier);
        } catch (SQLException e) {
            log.error("Impossible de basculer sur le schéma PostgreSQL {}", tenantIdentifier, e);
            connection.close();
            throw e;
        }
        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        log.trace("Libération de connexion pour le schéma : {}", tenantIdentifier);
        try (Statement statement = connection.createStatement()) {
            statement.execute("SET search_path TO " + TenantContext.DEFAULT_TENANT);
        } catch (SQLException e) {
            log.error("Impossible de réinitialiser la connexion vers le schéma public", e);
        } finally {
            releaseAnyConnection(connection);
        }
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    /**
     * @param aClass
     * @return
     */
    @Override
    public boolean isUnwrappableAs(Class<?> aClass) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }
}
