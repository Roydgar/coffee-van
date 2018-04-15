package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeDaoService;
import ua.training.model.service.SearchService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;

public class SearchCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        List<Coffee> coffees = CoffeeDaoService.findAll();
        request.setAttribute("coffees",  SearchService.searchCoffees(coffees, request));
        return SHOW_COFFEES_PAGE;
    }
}