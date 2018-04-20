package ua.training.util;

import ua.training.model.dao.CoffeeDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entity.Coffee;

import java.util.List;

public class CoffeeDaoUtil {

    private final static CoffeeDao dao = DaoFactory.getInstance().createCoffeeDao();

    public static void create(Coffee coffee) { dao.create(coffee); }

    public static Coffee findById(int id) { return dao.findById(id); }

    public static List<Coffee> findAll() { return dao.findAll(); }

    public static void update(Coffee coffee) { dao.update(coffee); }

    public static void delete(int id) { dao.delete(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }

}
