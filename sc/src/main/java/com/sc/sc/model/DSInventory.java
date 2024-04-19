package com.sc.sc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "ds_inventory")
public class DSInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    private DSInventoryStatus status;

    private int quantity;

    // Constructors
    public DSInventory() {
    }

    public DSInventory(Product product, DSInventoryStatus status, int quantity) {
        this.product = product;
        this.status = status;
        this.quantity = quantity;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getproduct() {
        return product;
    }

    public void setproduct(Product product) {
        this.product = product;
    }

    public DSInventoryStatus getStatus() {
        return status;
    }

    public void setStatus(DSInventoryStatus status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
