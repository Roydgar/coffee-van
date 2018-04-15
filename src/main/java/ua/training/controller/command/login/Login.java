package ua.training.controller.command.login;

import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.model.service.UserDaoService;
import ua.training.util.constants.AttributeNames;
import ua.training.util.constants.Messages;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static ua.training.util.constants.URLs.REDIRECT_LOGIN_PAGE;
import static ua.training.util.constants.URLs.REDIRECT_SHOW_COFFEES_PAGE;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter(AttributeNames.USERNAME);
        String password = request.getParameter(AttributeNames.PASSWORD);

        if (username == null || password == null) {
            return REDIRECT_LOGIN_PAGE;
        }

        Optional<User> user = Optional.ofNullable(UserDaoService.login(username.toString(), password));

        if (!user.isPresent()) {
            request.getSession().setAttribute(AttributeNames.LOGIN_ERROR, Messages.LOGIN_ERROR);
            return REDIRECT_LOGIN_PAGE;
        }

        request.getSession().setAttribute(AttributeNames.USER, user.get());

        return REDIRECT_SHOW_COFFEES_PAGE;
    }
}
