package ua.training.model.service;

import ua.training.model.entity.Coffee;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;


public class SearchService {
    public static List<Coffee> searchCoffees(List<Coffee> coffees, HttpServletRequest request) {
        String searchBy = request.getParameter("searchBy");

        List<Coffee> result = new ArrayList<>();
        int from = Integer.parseInt(request.getParameter("from"));
        int to =   Integer.parseInt(request.getParameter("to"));

        if (searchBy.equals("weight")) {
            for (Coffee coffee : coffees) {
                if (coffee.getWeight() >= from && coffee.getWeight() <= to) {
                    result.add(coffee);
                }
            }
        } else if (searchBy.equals("price")) {
            for (Coffee coffee : coffees) {
                if (coffee.getPrice().compareTo(new BigDecimal(from)) >=0 &&
                        coffee.getPrice().compareTo(new BigDecimal(to)) <= 0) {
                    result.add(coffee);
                }
            }
        }

        return result;
    }
}
