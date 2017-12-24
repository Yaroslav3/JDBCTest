package miracle.dao;

import miracle.model.User;

import java.sql.SQLException;

public interface DaoUser {
    User getAll() throws SQLException;
    void create(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(int id) throws SQLException;
}
