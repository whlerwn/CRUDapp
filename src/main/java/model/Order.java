package model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderId;

    @Column(name = "customer")
    private String customer;

    @Column(name = "amount")
    private int amount;

    @OneToMany (mappedBy = "order",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @Fetch(value = FetchMode.JOIN)
    @Column(name = "product_id")
    private List<Product> products;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (name="order_store",
               joinColumns=@JoinColumn(name="order_id"),
               inverseJoinColumns=@JoinColumn(name="store_id"))
    private List<Store> stores;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
