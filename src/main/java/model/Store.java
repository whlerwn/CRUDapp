package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //каскадная связь
    @JoinTable (name="order_store",
               joinColumns=@JoinColumn(name="store_id"),
               inverseJoinColumns=@JoinColumn(name="order_id"))
    private List<Order> orders;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
