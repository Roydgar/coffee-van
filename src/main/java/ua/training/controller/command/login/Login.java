package ua.training.controller.command.login;

import ua.training.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.REDIRECT_LOGIN_PAGE;
import static ua.training.util.constants.URLs.REDIRECT_SHOW_COFFEES_PAGE;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("UP: " + username + "; " + password);

        if (username == null || password == null ) {
            return REDIRECT_LOGIN_PAGE;
        }

        return REDIRECT_SHOW_COFFEES_PAGE;
    }
}
