package ua.training.model.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class Coffee {
    private String name;
    private int weight;
    private CoffeeState state;
    private int id;
    private BigDecimal price;


    public Coffee() {
    }

    public Coffee(int id, String name, int weight, CoffeeState state, BigDecimal price) {
        this.id     = id;
        this.name   = name;
        this.weight = weight;
        this.state  = state;
        this.price  = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CoffeeState getState() {
        return state;
    }

    public void setState(CoffeeState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
                "name=" + name +
                ", weight=" + weight +
                ", state=" + state +
                ", price=" + price +
                '}';
    }
}
