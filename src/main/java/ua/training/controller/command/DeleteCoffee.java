package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeDaoService;
import ua.training.model.service.CustomOrderService;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.SHOW_COFFEE_VAN_PAGE;

public class DeleteCoffee implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Coffee coffee = CoffeeDaoService.findById(Integer.parseInt(request.getParameter("id")));
        CustomOrderService.deleteFromOrder(coffee);

        request.setAttribute(AttributeNames.ORDER, CustomOrderService.getOrder());
        request.setAttribute(AttributeNames.TOTAL_PRICE, CustomOrderService.getTotalPrice());
        request.setAttribute(AttributeNames.TOTAL_WEIGHT, CustomOrderService.getTotalWeight());
        request.setAttribute(AttributeNames.MAX_WEIGHT, CustomOrderService.getMaxWeight());

        return SHOW_COFFEE_VAN_PAGE;
    }
}
