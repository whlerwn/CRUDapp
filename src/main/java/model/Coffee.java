package model;

import java.util.Objects;

public class Coffee {
    private int id;
    private String name;
    private String country;
    private int amount;

    public Coffee(int id, String name, String country, int amount) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.amount = amount;
    }

    public Coffee(String name, String country, int amount) {
        this.name = name;
        this.country = country;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return id == coffee.id && amount == coffee.amount && Objects.equals(name, coffee.name) && Objects.equals(country, coffee.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
