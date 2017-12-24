package miracle.Controller;

import miracle.config.Database;
import miracle.dao.DaoUser;
import miracle.dao.impl.DaoUserImpl;
import miracle.model.Laptops;
import miracle.model.User;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {
        Database database = new Database();

        User user = new User();
        Laptops ipatops = new Laptops();
        DaoUser daoUser = new DaoUserImpl();

        System.out.println(daoUser.getAll());


    }
}
