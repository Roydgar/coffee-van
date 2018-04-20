package ua.training.controller.command.admin;

import ua.training.controller.command.Command;
import ua.training.util.CoffeeDaoUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.REDIRECT_SHOW_COFFEES_PAGE;

public class RemoveCoffee implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        CoffeeDaoUtil.delete(Integer.parseInt(request.getParameter(AttributeNames.ID)));

        request.getSession().setAttribute(AttributeNames.COFFEES, CoffeeDaoUtil.findAll());
        return REDIRECT_SHOW_COFFEES_PAGE;
    }
}
