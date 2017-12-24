package com.test;

import com.mysql.fabric.jdbc.FabricMySQLConnection;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NET = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id = ?";

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

//
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            preparedStatement = connection.prepareStatement(INSERT_NET);
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "Inserted title");
//            preparedStatement.setString(3, "Inserted dek");
//            preparedStatement.setFloat(4, 0.2f);
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7,new FileInputStream("src\\main\\resources\\icons850.png"));
//
//            preparedStatement.execute();
//
//
//        } catch (SQLException | FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(DELETE);

            preparedStatement.setInt(1,1);
            preparedStatement.executeUpdate();


            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String title = resultSet.getString("title");
//                String description = resultSet.getString("description");
//                double rating = resultSet.getDouble("rating");
//                Date date = resultSet.getDate("created");
//                byte[] icon = resultSet.getBytes("icon");
//
//                System.out.println("icon " + icon.length);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}