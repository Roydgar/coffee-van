package ua.training.controller.command.admin;

import ua.training.controller.command.Command;
import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeService;
import ua.training.util.CoffeeDaoUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static ua.training.util.constants.URLs.ADD_COFFEE_PAGE;
import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;

public class AddCoffee implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        Optional<Coffee> coffee = Optional.ofNullable(CoffeeService.createCoffee(request));

        if (!coffee.isPresent()) {
            request.setAttribute(AttributeNames.ID, request.getParameter("id"));
            return ADD_COFFEE_PAGE;
        }

        CoffeeDaoUtil.create(coffee.get());

        request.getSession().setAttribute(AttributeNames.COFFEES, CoffeeDaoUtil.findAll());
        return SHOW_COFFEES_PAGE;
    }
}
