package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.entity.FullCoffeeVanException;
import ua.training.model.service.CoffeeService;
import ua.training.util.CoffeeDaoUtil;
import ua.training.util.CustomOrderUtil;
import ua.training.util.constants.AttributeNames;
import ua.training.util.constants.Messages;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.*;

public class ShowCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().setAttribute(AttributeNames.COFFEES, CoffeeService.createCoffeeList(request));

        int countToOrder = request.getParameter(AttributeNames.COUNT) == null ? 0
                : Integer.parseInt(request.getParameter(AttributeNames.COUNT));

        if (countToOrder != 0) {
            Coffee coffee =  CoffeeDaoUtil.findById(Integer.parseInt(request.getParameter(AttributeNames.ID)));
            try {
                CustomOrderUtil.addToOrder(coffee, countToOrder);
            } catch (FullCoffeeVanException e) {
                request.setAttribute(AttributeNames.FULL_COFFEE_VAN, Messages.COFFEE_VAN_IS_FULL);
            }
        }

        return SHOW_COFFEES_PAGE;
    }


}
