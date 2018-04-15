package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.entity.FullCoffeeVanException;
import ua.training.model.service.CoffeeDaoService;
import ua.training.model.service.CustomOrderService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.training.util.constants.URLs.*;

public class ShowCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Coffee> coffees = (List<Coffee>)request.getSession().getAttribute("coffees");

        request.getSession().setAttribute("coffees", coffees == null || request.getParameter("reset") != null
                ? CoffeeDaoService.findAll() : coffees);

        int countToOrder = request.getParameter("count") == null ? 0
                : Integer.parseInt(request.getParameter("count"));


        if (countToOrder != 0) {
            Coffee coffee =  CoffeeDaoService.findById(Integer.parseInt(request.getParameter("id")));
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
