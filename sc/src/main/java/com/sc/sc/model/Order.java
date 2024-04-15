package com.sc.sc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "custid", nullable = false)
    private int custId;

    @Column(name = "productid", nullable = false)
    private int productId;

    @Column(nullable = false)
    private String status;

    // Constructors, getters and setters, and other methods...

    // Getters
    public int getId() {
        return id;
    }

    public int getCustId() {
        return custId;
    }

    public int getProductId() {
        return productId;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
