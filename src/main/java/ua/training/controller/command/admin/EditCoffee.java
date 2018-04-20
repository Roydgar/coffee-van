package ua.training.controller.command.admin;

import ua.training.controller.command.Command;
import ua.training.model.entity.Coffee;
import ua.training.model.entity.CoffeeState;
import ua.training.model.service.CoffeeService;
import ua.training.util.CoffeeDaoUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.util.Optional;

import static ua.training.util.constants.URLs.EDIT_COFFEE_PAGE;
import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;

public class EditCoffee implements Command{
    private int coffeeId;

    @Override
    public String execute(HttpServletRequest request) {

        Optional<Coffee> coffee = Optional.ofNullable(CoffeeService.createCoffee(request));

        if (!coffee.isPresent()) {
            coffeeId = Integer.parseInt(request.getParameter(AttributeNames.ID));
            return EDIT_COFFEE_PAGE;
        }

        CoffeeDaoUtil.update(coffee.get());

        request.getSession().setAttribute(AttributeNames.COFFEES, CoffeeDaoUtil.findAll());
        return SHOW_COFFEES_PAGE;
    }
}
