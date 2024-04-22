// MWInventory.java
package com.sc.sc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mw_inventory")
public class MWInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

    private Long quantity;

    // Constructors
    public MWInventory() {
    }

    public MWInventory(Product product, Long quantity) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
