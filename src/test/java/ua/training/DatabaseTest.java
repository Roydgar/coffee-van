package ua.training;

import org.junit.Test;
import ua.training.model.dao.CoffeeDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.CoffeeState;
import ua.training.model.entity.User;
import ua.training.model.entity.builder.CoffeeBuilder;
import ua.training.model.entity.builder.UserBuilder;
import ua.training.model.dao.util.ConnectionUtils;

import java.math.BigDecimal;
import java.sql.*;

public class DatabaseTest {
    CoffeeDao coffeeDao = DaoFactory.getInstance().createCoffeeDao();
    UserDao   userDao   = DaoFactory.getInstance().createUserDao();
    @Test
    public void testConnection() {
        try {
            Connection con = ConnectionUtils.getCoffeeDbConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE coffee (" +
                    "  coffeeId INT NOT NULL AUTO_INCREMENT," +
                    "  name VARCHAR(255) NOT NULL," +
                    "  weight INT NOT NULL," +
                    "  state VARCHAR(45) NOT NULL," +
                    "  price VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (coffeeId))");

            /*Connection con = ConnectionUtils.getUserDbConnection();
            Statement statement = con.createStatement();

            statement.executeUpdate("CREATE TABLE user(" +
                    "  userId INT NOT NULL AUTO_INCREMENT," +
                    "  username VARCHAR(255) NOT NULL," +
                    "  password VARCHAR(255) NOT NULL," +
                    "  role VARCHAR(40) NOT NULL," +
                    "  PRIMARY KEY (userId))");
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() {
      // coffeeDao.create(new CoffeeBuilder().setName("Big Black Bean").setWeight(5)
                      //.setState(CoffeeState.BEANS).setPrice(new BigDecimal("1.5")).buildCoffee());
        //userDao.create(new UserBuilder().setUsername("pups").setPassword("228666").setRole(User.Role.ADMIN).buildUser());
    }

    @Test
    public void testFindAll(){
        System.out.println(coffeeDao.findAll());
    }

    @Test
    public void testFindById() {
        System.out.println(coffeeDao.findById(3));
    }

    @Test
    public void testLogin() {
        System.out.println(userDao.userExists("Divan"));
    }
    @Test
    public void testDelete(){
        userDao.delete(1); userDao.delete(2) ; userDao.delete(3);;
    }


}

