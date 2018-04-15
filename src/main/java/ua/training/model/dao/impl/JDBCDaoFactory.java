package ua.training.model.dao.impl;

import ua.training.model.dao.CoffeeDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;

import java.sql.SQLException;

import static ua.training.model.dao.util.ConnectionUtils.getCoffeeDbConnection;
import static ua.training.model.dao.util.ConnectionUtils.getUserDbConnection;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public CoffeeDao createCoffeeDao() {
        try {
            return new JDBCCoffeeDao(getCoffeeDbConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDao createUserDao() {
        try {
            return new JDBCUserDao(getUserDbConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
