package ua.training.model.service;

import ua.training.model.dao.CoffeeDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.Coffee;
import ua.training.model.entity.User;

import java.util.List;

public class UserDaoService {

    private final static UserDao dao = DaoFactory.getInstance().createUserDao();

    public static void create(User user) { dao.create(user); }

    public static User findById(int id) { return dao.findById(id); }

    public static List<User> findAll() { return dao.findAll(); }

    public static void update(User user) { dao.update(user); }

    public static void delete(int id) { dao.delete(id); }

    public static User login(String username, String password) { return dao.login(username, password); }

    public static boolean userExists(String username) { return dao.userExists(username); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }

}
