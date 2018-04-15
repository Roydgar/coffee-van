package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.entity.FullCoffeeVanException;
import ua.training.model.service.CustomOrderService;
import ua.training.model.service.DaoService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.*;

public class ShowCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("coffees",  DaoService.findAll());

        int countToOrder = request.getParameter("count") == null ? 0
                : Integer.parseInt(request.getParameter("count"));


        if (countToOrder != 0) {
            Coffee coffee = DaoService.findById(Integer.parseInt(request.getParameter("id")));
            try {
                CustomOrderService.addToOrder(coffee, countToOrder);
            } catch (FullCoffeeVanException e) {
                e.printStackTrace();
                request.setAttribute("fullCoffeeVan", "Your coffee Van is full!");
            }
        }

        return SHOW_COFFEES_PAGE;
    }


}