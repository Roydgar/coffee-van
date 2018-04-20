package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeVanService;
import ua.training.util.CoffeeDaoUtil;
import ua.training.util.CustomOrderUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.SHOW_COFFEE_VAN_PAGE;

public class DeleteCoffee implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Coffee coffee = CoffeeDaoUtil.findById(Integer.parseInt(request.getParameter("id")));
        CustomOrderUtil.deleteFromOrder(coffee);

        CoffeeVanService.setCoffeeVanParameters(request);

        return SHOW_COFFEE_VAN_PAGE;
    }
}
