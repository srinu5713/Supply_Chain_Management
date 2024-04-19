package com.sc.sc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "req_production")
public class ReqProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reqId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private ProductionStatus status;

    // Constructors
    public ReqProduction() {
    }

    public ReqProduction(Product product, int quantity, ProductionStatus status) {
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters and setters
    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductionStatus getStatus() {
        return status;
    }

    public void setStatus(ProductionStatus status) {
        this.status = status;
    }
}
