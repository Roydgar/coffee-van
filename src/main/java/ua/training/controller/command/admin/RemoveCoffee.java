package ua.training.controller.command.admin;

import ua.training.controller.command.Command;
import ua.training.model.service.CoffeeDaoService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.REDIRECT_SHOW_COFFEES_PAGE;

public class RemoveCoffee implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        CoffeeDaoService.delete(Integer.parseInt(request.getParameter("id")));

        request.getSession().setAttribute("coffees", CoffeeDaoService.findAll());
        return REDIRECT_SHOW_COFFEES_PAGE;
    }
}
