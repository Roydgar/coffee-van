package ua.training.model.service;

import ua.training.model.entity.Coffee;
import ua.training.model.entity.CoffeeState;
import ua.training.util.CoffeeDaoUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public class CoffeeService {

    public static Coffee createCoffee(HttpServletRequest request) {
        String name = request.getParameter(AttributeNames.NAME);
        String weight = request.getParameter(AttributeNames.WEIGHT);
        String state  = request.getParameter(AttributeNames.STATE);
        String price  = request.getParameter(AttributeNames.PRICE);

        if (name == null || weight == null || state == null || price == null) {
            return null;
        }

        if (name.isEmpty() || weight.isEmpty() || state.isEmpty() || price.isEmpty()) {
            return null;
        }

        return new Coffee.CoffeeBuilder().setName(name).setWeight(Integer.parseInt(weight))
                .setState(CoffeeState.valueOf(state)).setPrice(new BigDecimal(price)).buildCoffee();
    }

    public static List<Coffee> createCoffeeList(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Coffee> coffees = (List<Coffee>)request.getSession().getAttribute(AttributeNames.COFFEES);
        return  coffees == null
                || request.getParameter(AttributeNames.RESET_FILTERS) != null
                ? CoffeeDaoUtil.findAll() : coffees;
    }

}
