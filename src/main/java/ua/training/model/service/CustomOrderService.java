package ua.training.model.service;

import ua.training.controller.command.Command;
import ua.training.model.entity.Coffee;
import ua.training.model.entity.CoffeeVan;
import ua.training.model.entity.FullCoffeeVanException;

import java.util.Map;

public class CustomOrderService {
    private static CoffeeVan coffeeVan = new CoffeeVan();

    public static void addToOrder(Coffee coffee, int count) throws FullCoffeeVanException{
        coffeeVan.add(coffee, count);
    }

    public static Map<Coffee, Integer> getOrder() { return coffeeVan.get(); }

    public static void deleteFromOrder(Coffee coffee) { coffeeVan.delete(coffee);}

    public static int getMaxWeight() {
        return coffeeVan.getMaxWeight();
    }

    public static int getTotalWeight() {
        return coffeeVan.getTotalWeight();
    }

    public static double getTotalPrice() { return coffeeVan.getTotalPrice().doubleValue(); }
}
