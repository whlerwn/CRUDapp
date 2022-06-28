package model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;

    @ManyToOne(fetch = FetchType.LAZY) //предотвращение N+1
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Order order;

    @Column(name = "name")
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int id, String name) {
        this.productId = id;
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
