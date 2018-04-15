package ua.training.controller.command;

import ua.training.model.service.DaoService;
import ua.training.model.service.SortService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;


public class SortCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("coffees",  SortService.sortCoffees( DaoService.findAll(), request));

        return SHOW_COFFEES_PAGE;
    }
}