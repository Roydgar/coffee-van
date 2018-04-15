package ua.training;

import org.junit.Test;
import ua.training.model.dao.CoffeesDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entity.Coffee;
import ua.training.model.entity.CoffeeState;
import ua.training.model.util.ConnectionUtils;

import java.math.BigDecimal;
import java.sql.*;

public class DatabaseTest {
    CoffeesDao dao = DaoFactory.getInstance().createCoffeesDao();

    @Test
    public void testConnection() {
        try {
            /*Connection con = ConnectionUtils.getCoffeesDbConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE coffees (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  name VARCHAR(45) NULL," +
                    "  weight INT NULL," +
                    "  state VARCHAR(45) NULL," +
                    "  price VARCHAR(45) NULL," +
                    "  PRIMARY KEY (id))");*/

            Connection con = ConnectionUtils.getUsersDbConnection();
            Statement statement = con.createStatement();

            statement.executeUpdate("CREATE TABLE users(" +
                    "  userId INT NOT NULL AUTO_INCREMENT," +
                    "  username VARCHAR(255) NOT NULL," +
                    "  password VARCHAR(255) NOT NULL," +
                    "  role INT NOT NULL," +
                    "  PRIMARY KEY (userId))");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() {
        dao.create(new Coffee("Pups power", 1000, CoffeeState.BEANS, new BigDecimal("5.5")));

    }

    @Test
    public void testFindAll(){
        System.out.println(dao.findAll());
    }

    @Test
    public void testFindById() {
        System.out.println(dao.findById(1));
    }

    @Test
    public void testDelete(){
        dao.delete(7); dao.delete(8);
    }


}

