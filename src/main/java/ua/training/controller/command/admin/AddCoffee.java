package ua.training.controller.command.admin;

import ua.training.controller.command.Command;
import ua.training.model.entity.CoffeeState;
import ua.training.model.entity.builder.CoffeeBuilder;
import ua.training.model.service.CoffeeDaoService;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;

import static ua.training.util.constants.URLs.ADD_COFFEE_PAGE;
import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;

public class AddCoffee implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String state  = request.getParameter("state");
        String price  = request.getParameter("price");

        if (name == null) {
            request.setAttribute("id", request.getParameter("id"));
            return ADD_COFFEE_PAGE;
        }

        CoffeeDaoService.create(new CoffeeBuilder().setName(name).setWeight(Integer.parseInt(weight))
                .setState(CoffeeState.valueOf(state)).setPrice(new BigDecimal(price)).buildCoffee());

        request.getSession().setAttribute("coffees", CoffeeDaoService.findAll());
        return SHOW_COFFEES_PAGE;
    }
}
