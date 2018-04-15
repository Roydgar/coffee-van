package ua.training.model.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static ua.training.model.dao.impl.constants.ConnectionConstants.*;


public class ConnectionUtils {
    static {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCoffeeDbConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(COFFEE_DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        return connection;
    }

    public static Connection getUserDbConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(USER_DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        return connection;
    }
}
