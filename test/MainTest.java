package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {
    public static void main(String[] args) {
        JDBCtest jdbCtest = new JDBCtest();
        jdbCtest.writeAnimals();

        String qeare = "select * from animal";

        try {
            Statement statement = jdbCtest.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(qeare);

            while (resultSet.next()) {
                Animals animals = new Animals();
                animals.setId(resultSet.getInt("id"));
                animals.setName(resultSet.getString("name"));
                animals.setAge(resultSet.getInt("age"));
                System.out.println(animals);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
