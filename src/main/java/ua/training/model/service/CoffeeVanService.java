package ua.training.model.service;

import ua.training.util.CustomOrderUtil;
import ua.training.util.constants.AttributeNames;

import javax.servlet.http.HttpServletRequest;

public class CoffeeVanService {
    public static void setCoffeeVanParameters(HttpServletRequest request) {
        request.setAttribute(AttributeNames.ORDER, CustomOrderUtil.getOrder());
        request.setAttribute(AttributeNames.TOTAL_PRICE, CustomOrderUtil.getTotalPrice());
        request.setAttribute(AttributeNames.TOTAL_WEIGHT, CustomOrderUtil.getTotalWeight());
        request.setAttribute(AttributeNames.MAX_WEIGHT, CustomOrderUtil.getMaxWeight());
    }
}
