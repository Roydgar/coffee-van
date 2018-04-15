package ua.training.controller.command;


import ua.training.model.service.CustomOrderService;

import javax.servlet.http.HttpServletRequest;
import static ua.training.util.constants.URLs.*;


public class ShowCoffeeVan implements Command {
    private CustomOrderService customOrderService = new CustomOrderService();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("order", customOrderService.getOrder());
        request.setAttribute("totalPrice",customOrderService.getTotalPrice());

        request.setAttribute("maxWeight", customOrderService.getMaxWeight());
        request.setAttribute("totalWeight", customOrderService.getTotalWeight());
        return SHOW_COFFEE_VAN_PAGE;
    }
}