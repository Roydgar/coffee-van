package ua.training.controller.command.login;

import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.service.UserDaoService;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static ua.training.util.constants.URLs.REDIRECT_LOGIN_PAGE;
import static ua.training.util.constants.URLs.REDIRECT_SHOW_COFFEES_PAGE;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            return REDIRECT_LOGIN_PAGE;
        }

        Optional<User> user = Optional.ofNullable(UserDaoService.login(username.toString(), password));

        if (!user.isPresent()) {
            request.getSession().setAttribute("loginError", "Wrong login or password!");
            System.out.println("LoginError");
            return REDIRECT_LOGIN_PAGE;
        }

        request.getSession().setAttribute("user", user.get());

        return REDIRECT_SHOW_COFFEES_PAGE;
    }
}
