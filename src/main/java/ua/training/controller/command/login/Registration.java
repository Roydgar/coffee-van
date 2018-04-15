package ua.training.controller.command.login;

import ua.training.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.REDIRECT_LOGIN_PAGE;
import static ua.training.util.constants.URLs.REDIRECT_REGISTRATION_PAGE;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("UP: " + username + "; " + password);
        System.out.println("SDAFDSAFSD");
        if (username == null || password == null ) {
            return REDIRECT_REGISTRATION_PAGE;
        }

        return REDIRECT_LOGIN_PAGE;
    }
}