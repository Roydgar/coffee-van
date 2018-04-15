package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeDaoService;
import ua.training.util.SortUtil;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;


public class SortCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Coffee> coffees = (List<Coffee>)request.getSession().getAttribute("coffees");
        List<Coffee> sortedCoffees = coffees == null ?
                SortUtil.sortCoffees(CoffeeDaoService.findAll(), request) :
                SortUtil.sortCoffees(coffees, request);

        request.getSession().setAttribute("coffees", sortedCoffees );

        return SHOW_COFFEES_PAGE;
    }
}
