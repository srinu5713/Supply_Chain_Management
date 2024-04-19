package com.sc.sc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "mw_inventory")
public class MWInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product;

    private int quantity;

    // Constructors
    public MWInventory() {
    }

    public MWInventory(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public product getproduct() {
        return product;
    }

    public void setproduct(product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
