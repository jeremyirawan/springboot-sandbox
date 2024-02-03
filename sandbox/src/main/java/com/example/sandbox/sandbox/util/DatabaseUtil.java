package com.example.sandbox.sandbox.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUtil{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(DatabaseUtil.class);

    public void checkDatabaseConnection() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            logger.info("Database connection successful.");
        } catch (Exception e) {
            logger.error("Error connecting to database: " + e.getMessage());
        }
    }

    public void checkDatabaseExists() {
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource == null) {
            logger.error( "Error: JdbcTemplate has not been initialized with a valid DataSource.");
            return;
        }
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            String dbName = metaData.getDatabaseProductName();
            if (!dbName.equals("sandbox")) {
                logger.error("The current database is not'sandbox'. Expected'sandbox' but found: " + dbName);
                return;
            }
            logger.info("The 'sandbox' database exists.");
        } catch (SQLException e) {
            logger.error("Error checking database existence: " + e.getMessage());
        }
    }
}
