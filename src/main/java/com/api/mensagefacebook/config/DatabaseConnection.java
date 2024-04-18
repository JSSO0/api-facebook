package com.api.mensagefacebook.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/api_facebook";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
