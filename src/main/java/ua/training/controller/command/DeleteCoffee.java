package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeDaoService;
import ua.training.model.service.CustomOrderService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.SHOW_COFFEE_VAN_PAGE;

public class DeleteCoffee implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Coffee coffee = CoffeeDaoService.findById(Integer.parseInt(request.getParameter("id")));
        CustomOrderService.deleteFromOrder(coffee);

        request.setAttribute("order", CustomOrderService.getOrder());
        request.setAttribute("totalPrice", CustomOrderService.getTotalPrice());
        request.setAttribute("totalWeight", CustomOrderService.getTotalWeight());
        request.setAttribute("maxWeight", CustomOrderService.getMaxWeight());

        return SHOW_COFFEE_VAN_PAGE;
    }
}
