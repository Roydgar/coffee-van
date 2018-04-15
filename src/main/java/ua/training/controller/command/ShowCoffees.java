package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.entity.FullCoffeeVanException;
import ua.training.model.service.CoffeeDaoService;
import ua.training.model.service.CustomOrderService;
import ua.training.util.constants.AttributeNames;
import ua.training.util.constants.Messages;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.training.util.constants.URLs.*;

public class ShowCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Coffee> coffees = (List<Coffee>)request.getSession().getAttribute(AttributeNames.COFFEES);

        request.getSession().setAttribute(AttributeNames.COFFEES, coffees == null
                || request.getParameter(AttributeNames.RESET) != null
                ? CoffeeDaoService.findAll() : coffees);

        int countToOrder = request.getParameter(AttributeNames.COUNT) == null ? 0
                : Integer.parseInt(request.getParameter(AttributeNames.COUNT));


        if (countToOrder != 0) {
            Coffee coffee =  CoffeeDaoService.findById(Integer.parseInt(request.getParameter(AttributeNames.ID)));
            try {
                CustomOrderService.addToOrder(coffee, countToOrder);
            } catch (FullCoffeeVanException e) {
                e.printStackTrace();
                request.setAttribute(AttributeNames.FULL_COFFEE_VAN, Messages.COFFEE_VAN_IS_FULL);
            }
        }

        return SHOW_COFFEES_PAGE;
    }


}
