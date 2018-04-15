package ua.training.model.dao.impl;

import ua.training.model.dao.CoffeesDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.util.ConnectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public CoffeesDao createCoffeesDao() {
        return new JDBCCoffeesDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return ConnectionUtils.getCoffeesDbConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}