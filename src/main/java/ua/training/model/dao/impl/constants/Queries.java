package ua.training.model.dao.impl.constants;


import java.util.ResourceBundle;

public interface Queries {
    ResourceBundle bundle = ResourceBundle.getBundle("dao");

    String CREATE       = bundle.getString("query.create");
    String FIND_BY_ID   = bundle.getString("query.findById");
    String FIND_ALL     = bundle.getString("query.findAll");
    String UPDATE       = bundle.getString("query.update");
    String DELETE       = bundle.getString("query.delete");
}
