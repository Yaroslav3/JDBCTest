package com.jdbc.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/brihday";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

        } catch (SQLException e) {

        }
    }
}

