package ua.training.model.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CoffeeVan{
    private Map<Coffee, Integer> van = new HashMap<>();

    private final int MAX_WEIGHT = 10000;

    private int totalWeight;
    private BigDecimal totalPrice = new BigDecimal("0");

    public  void add(Coffee coffee, int count) throws FullCoffeeVanException{
        if (totalWeight + coffee.getWeight() * count > MAX_WEIGHT) {
            throw new FullCoffeeVanException("Coffee van is full");
        }
        van.put(coffee, van.get(coffee) == null ? count : van.get(coffee) + count);

        totalWeight += coffee.getWeight() * count;

        totalPrice = totalPrice.add(coffee.getPrice().multiply(new BigDecimal(count)));
    }

    public  Map<Coffee, Integer> get() { return van; }

    public  void delete(Coffee coffee) {
        int count = van.get(coffee);
        totalPrice = totalPrice.subtract(coffee.getPrice().multiply(new BigDecimal(count)));
        totalWeight -= coffee.getWeight() * count;
        van.remove(coffee);
    }

    public int getMaxWeight() {
        return MAX_WEIGHT;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
