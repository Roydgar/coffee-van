package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.model.service.CoffeeDaoService;
import ua.training.util.SortUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;


public class SortCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Coffee> sortedCoffees = SortUtil.sortCoffees(
                (List<Coffee>)request.getSession().getAttribute(AttributeNames.COFFEES), request);

        request.getSession().setAttribute(AttributeNames.COFFEES, sortedCoffees );

        return SHOW_COFFEES_PAGE;
    }
}
