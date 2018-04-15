package ua.training.model.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class Coffee {
    private Optional<String> name;
    private int weight;
    private Optional<CoffeeState> state;
    private int id;
    private Optional<BigDecimal> price;

    public Coffee(String name, int weight, CoffeeState state, BigDecimal price) {
        this(0, name, weight, state, price);
    }

    public Coffee(int id, String name, int weight, CoffeeState state, BigDecimal price) {
        this.id = id;
        this.name = Optional.of(name);
        this.weight = weight;
        this.state = Optional.of(state);
        this.price = Optional.of(price);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = Optional.of(name);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CoffeeState getState() {
        return state.get();
    }

    public void setState(CoffeeState state) {
        this.state = Optional.of(state);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price.get();
    }

    public void setPrice(BigDecimal price) {
        this.price = Optional.of(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return weight == coffee.weight &&
                id == coffee.id &&
                Objects.equals(name, coffee.name) &&
                Objects.equals(state, coffee.state) &&
                Objects.equals(price, coffee.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, weight, state, id, price);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                "name=" + name.get() +
                ", weight=" + weight +
                ", state=" + state.get() +
                ", price=" + price.get() +
                '}';
    }
}
