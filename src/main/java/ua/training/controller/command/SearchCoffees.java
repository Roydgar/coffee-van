package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeDaoService;
import ua.training.util.SearchUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;

public class SearchCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Coffee> coffees = (List<Coffee>)request.getSession().getAttribute("coffees");

        List<Coffee> searchedCoffees = coffees == null ?
                SearchUtil.searchCoffees(CoffeeDaoService.findAll(), request) :
                SearchUtil.searchCoffees(coffees, request);

        request.getSession().setAttribute("coffees", searchedCoffees );

        return SHOW_COFFEES_PAGE;
    }
}