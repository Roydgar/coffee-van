package ua.training.model.entity.builder;

import ua.training.model.entity.Coffee;
import ua.training.model.entity.CoffeeState;

import java.math.BigDecimal;

public class CoffeeBuilder {
    private Coffee coffee = new Coffee();

    public CoffeeBuilder() {
    }

    public CoffeeBuilder setId(int id) {
        coffee.setId(id);
        return this;
    }

    public CoffeeBuilder setName(String name) {
        coffee.setName(name);
        return this;
    }

    public CoffeeBuilder setWeight(int weight) {
        coffee.setWeight(weight);
        return this;
    }

    public CoffeeBuilder setPrice(BigDecimal price) {
        coffee.setPrice(price);
        return this;
    }

    public CoffeeBuilder setState(CoffeeState state) {
        coffee.setState(state);
        return this;
    }

    public Coffee buildCoffee() {
        return coffee;
    }
}
