package ua.training.controller.command.login;

import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.entity.builder.UserBuilder;
import ua.training.model.service.UserDaoService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.REDIRECT_LOGIN_PAGE;
import static ua.training.util.constants.URLs.REDIRECT_REGISTRATION_PAGE;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        System.out.println("UP: " + username + "; " + password);

        if (username == null || password == null || confirmPassword == null) {
            return REDIRECT_REGISTRATION_PAGE;
        }

        if (UserDaoService.userExists(username)) {
            request.getSession().setAttribute("registrationError", "User with this login already exists");
            return REDIRECT_REGISTRATION_PAGE;
        }

        if (!password.equals(confirmPassword)) {
            request.getSession().setAttribute("registrationError", "Passwords dont match.");
            return REDIRECT_REGISTRATION_PAGE;
        }

        UserDaoService.create(new UserBuilder().setUsername(username.toLowerCase()).setPassword(password)
                .setRole(User.Role.USER).buildUser());

        return REDIRECT_LOGIN_PAGE;
    }
}