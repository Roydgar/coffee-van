package ua.training.controller.command;

import ua.training.model.entity.Coffee;
import ua.training.util.SearchUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.util.constants.URLs.SHOW_COFFEES_PAGE;

public class SearchCoffees implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<Coffee> searchedCoffees = SearchUtil.searchCoffees(
                (List<Coffee>)request.getSession().getAttribute(AttributeNames.COFFEES), request);

        request.getSession().setAttribute(AttributeNames.COFFEES, searchedCoffees );

        return SHOW_COFFEES_PAGE;
    }
}