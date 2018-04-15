package ua.training.model.service;

import ua.training.model.dao.CoffeesDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entity.Coffee;

import java.io.IOException;
import java.util.List;

public class DaoService {
    private final static CoffeesDao dao = DaoFactory.getInstance().createCoffeesDao();

    public static List<Coffee> findAll() { return dao.findAll(); }

    public static Coffee findById(int id) { return dao.findById(id); }

    public static void close() {
        try {
            dao.close();
        } catch (Exception e)  {
            throw new RuntimeException(e);
        }
    }
}
