package test;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class JDBCtest {

    private final String HOST = "jdbc:mysql://localhost:3306/users";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

   private Connection connection;

    public void JDBCtest() {
        try {
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeAnimals() {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
          //  statement.execute("INSERT INTO animal(id, name, age) VALUES (3,'Sneak',1);");
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
