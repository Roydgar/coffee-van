package ua.training.controller.command;


import ua.training.model.service.CoffeeVanService;
import ua.training.util.CustomOrderUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;
import static ua.training.util.constants.URLs.*;


public class ShowCoffeeVan implements Command {
    private CustomOrderUtil customOrderUtil = new CustomOrderUtil();
    @Override
    public String execute(HttpServletRequest request) {
        CoffeeVanService.setCoffeeVanParameters(request);

        return SHOW_COFFEE_VAN_PAGE;
    }
}