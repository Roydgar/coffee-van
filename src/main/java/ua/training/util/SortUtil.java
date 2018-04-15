package ua.training.util;

import ua.training.model.entity.Coffee;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortUtil {
    public static List<Coffee> sortCoffees(List<Coffee> coffees, HttpServletRequest request) {
        String sortBy = request.getParameter("sortBy") == null ? "name" : request.getParameter("sortBy");

        if (sortBy.equals("name")) {
            coffees.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        } else if (sortBy.equals("weight")) {
            coffees.sort(Comparator.comparingInt(Coffee::getWeight));
        } else if (sortBy.equals("price to weight")) {
            coffees.sort(Comparator.comparing(o -> o.getPrice().divide(new BigDecimal(o.getWeight()),
                    BigDecimal.ROUND_CEILING)));
        } else if (sortBy.equals("price")) {
            coffees.sort(Comparator.comparing(Coffee::getPrice));
        }

        return coffees;
    }

}
