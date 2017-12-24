package miracle.servise.impl;

import miracle.dao.DaoUser;
import miracle.dao.impl.DaoUserImpl;
import miracle.model.User;
import miracle.servise.UserService;

import java.sql.SQLException;

public class UserServiseImpl implements UserService {

    @Override
    public User getAll() throws SQLException {
        DaoUser daoUser = null;
        try {
            daoUser = new DaoUserImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert daoUser != null;
        return daoUser.getAll();
    }

    @Override
    public void create(User user) {
        try {
            DaoUser daoUser = new DaoUserImpl();
             daoUser.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            DaoUser daoUser = new DaoUserImpl();
            daoUser.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            DaoUser daoUser = new DaoUserImpl();
            daoUser.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
