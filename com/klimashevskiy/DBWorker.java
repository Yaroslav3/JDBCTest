package com.klimashevskiy;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBWorker {
    private final String HOST = "jdbc:mysql://localhost:3306/users";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeDatabaseUser() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO users (id,username,password) VALUES (3,'Pavel','1236658Trqwe');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
