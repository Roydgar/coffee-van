package ua.training.controller.command.login;

import ua.training.controller.command.Command;
import ua.training.model.entity.User;
import ua.training.util.UserDaoUtil;
import ua.training.util.constants.AttributeNames;
import ua.training.util.constants.Messages;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.REDIRECT_LOGIN_PAGE;
import static ua.training.util.constants.URLs.REDIRECT_REGISTRATION_PAGE;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter(AttributeNames.USERNAME);
        String password = request.getParameter(AttributeNames.PASSWORD);
        String confirmPassword = request.getParameter(AttributeNames.CONFIRM_PASSWORD);

        if (username == null || password == null || confirmPassword == null) {
            return REDIRECT_REGISTRATION_PAGE;
        }

        if (UserDaoUtil.userExists(username)) {
            request.getSession().setAttribute(AttributeNames.REGISTRATION_ERROR,
                    Messages.NOT_UNIQUE_LOGIN_ERROR);
            return REDIRECT_REGISTRATION_PAGE;
        }

        if (!password.equals(confirmPassword)) {
            request.getSession().setAttribute(AttributeNames.REGISTRATION_ERROR, Messages.PASSWORD_DONT_MATCH_ERROR);
            return REDIRECT_REGISTRATION_PAGE;
        }

        UserDaoUtil.create(new User.UserBuilder().setUsername(username.toLowerCase()).setPassword(password)
                .setRole(User.Role.USER).buildUser());

        return REDIRECT_LOGIN_PAGE;
    }
}