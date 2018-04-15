package ua.training.model.dao.impl.constants;

import java.util.ResourceBundle;

public interface ConnectionConstants {

    ResourceBundle bundle       = ResourceBundle.getBundle("dao");

    String DATABASE_DRIVER      = bundle.getString("db.driver");

    String COFFEE_DATABASE_URL  = bundle.getString("db.coffee.url");
    String USER_DATABASE_URL    = bundle.getString("db.user.url");

    String DATABASE_USER        = bundle.getString("db.user");
    String DATABASE_PASSWORD    = bundle.getString("db.password");
}
