package com.bbank.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresSqlConnection {
    private PostresSqlConnection() {
    }

    private static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/postgres";
        String username="postgres";
        String password="password";
        return connection= DriverManager.getConnection(url,username,password);
    }
}
