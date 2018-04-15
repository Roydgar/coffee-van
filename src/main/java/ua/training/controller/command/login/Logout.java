package ua.training.controller.command.login;

import ua.training.controller.command.Command;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constants.URLs.INDEX_PAGE;

public class Logout implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute(AttributeNames.USER);

        return INDEX_PAGE;
    }
}
