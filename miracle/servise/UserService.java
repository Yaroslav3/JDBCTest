package miracle.servise;

import miracle.model.User;

import java.sql.SQLException;

public interface UserService {
        User getAll() throws SQLException;
        void create(User user);
        void update(User user);
        void delete(int id);
        }
