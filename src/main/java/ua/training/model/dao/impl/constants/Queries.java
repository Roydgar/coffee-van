package ua.training.model.dao.impl.constants;


import java.util.ResourceBundle;

public interface Queries {
    ResourceBundle bundle = ResourceBundle.getBundle("dao");

    String COFFEE_CREATE       = bundle.getString("query.coffee.create");
    String COFFEE_FIND_BY_ID   = bundle.getString("query.coffee.findById");
    String COFFEE_FIND_ALL     = bundle.getString("query.coffee.findAll");
    String COFFEE_UPDATE       = bundle.getString("query.coffee.update");
    String COFFEE_DELETE       = bundle.getString("query.coffee.delete");

    String USER_CREATE         = bundle.getString("query.user.create");
    String USER_FIND_BY_ID     = bundle.getString("query.user.findById");
    String USER_FIND_ALL       = bundle.getString("query.user.findAll");
    String USER_UPDATE         = bundle.getString("query.user.update");
    String USER_DELETE         = bundle.getString("query.user.delete");
    String USER_LOGIN      = bundle.getString("query.user.login");
}
