package ua.training.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static ua.training.model.util.ConnectionConstants.*;


public class ConnectionUtils {
    static {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCoffeesDbConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(COFFEES_DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        return connection;
    }

    public static Connection getUsersDbConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(USERS_DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        return connection;
    }
}
