package model;

import java.util.Objects;

public class Order {
    private int id;
    private String customer;
    private String address;
    private int productId;
    private int sum;
    private String country;
    private String sort;

    public Order() {
    }

    public Order(int productId, int sum) {
        this.productId = productId;
        this.sum = sum;
    }

    public Order(String customer, String address, int productId, int sum) {
        this.customer = customer;
        this.address = address;
        this.productId = productId;
        this.sum = sum;
    }

    public Order(int id, String customer, String address, int sum, String sort, String country) {
        this.id = id;
        this.customer = customer;
        this.address = address;
        this.sum = sum;
        this.sort = sort;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Order(int id, String customer, String address, int productId, int sum) {
        this.id = id;
        this.customer = customer;
        this.address = address;
        this.productId = productId;
        this.sum = sum;
    }
}
