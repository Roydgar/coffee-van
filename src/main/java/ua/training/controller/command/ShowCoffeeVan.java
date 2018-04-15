package ua.training.controller.command;


import ua.training.model.service.CustomOrderService;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;
import static ua.training.util.constants.URLs.*;


public class ShowCoffeeVan implements Command {
    private CustomOrderService customOrderService = new CustomOrderService();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(AttributeNames.ORDER, customOrderService.getOrder());
        request.setAttribute(AttributeNames.TOTAL_PRICE,customOrderService.getTotalPrice());

        request.setAttribute(AttributeNames.TOTAL_WEIGHT, customOrderService.getMaxWeight());
        request.setAttribute(AttributeNames.MAX_WEIGHT, customOrderService.getTotalWeight());
        return SHOW_COFFEE_VAN_PAGE;
    }
}