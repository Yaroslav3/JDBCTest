package miracle.dao.impl;

import miracle.config.Database;
import miracle.dao.DaoUser;
import miracle.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUserImpl implements DaoUser {
    private Connection connection = Database.getConnection();
    private final String INSERT_USER = "INSERT INTO miracle.users (name, skills) VALUES (?,?)";
    private final String UPDATE_USER = "UPDATE miracle.users SET name = ?,skills = ?";
    private final String DELETE = "DELETE FROM miracle.users WHERE id = ?";
    private final String ALL_USERS = "SELECT * FROM miracle.users";
    private static PreparedStatement preparedStatement;


    public DaoUserImpl() throws SQLException {
    }

    @Override
    public User getAll() throws SQLException {
        List<User> list = new ArrayList<>();
        preparedStatement = connection.prepareStatement(ALL_USERS);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = new User();

        while (resultSet.next()) {
            user.setName(resultSet.getString("name"));
            user.setSkills(resultSet.getString("skills"));
        }
        preparedStatement.close();
        connection.close();
        list.add(user);
        return user;
    }

    @Override
    public void create(User user) throws SQLException {

        try {
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSkills());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.execute();
            preparedStatement.close();

        }
    }

    @Override
    public void update(User user) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSkills());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            preparedStatement.close();
            connection.close();
        }

    }
}
