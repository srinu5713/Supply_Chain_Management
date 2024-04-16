package com.sc.sc.model;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "custid", nullable = false)
    private Long custId;

    @OneToMany
    @Column(name = "productid", nullable = false)
    private Long productId;

    @ManyToOne
    @Column(name="deliveryStationID", nullable = false)
    private Long deliveryID;

    @Column(nullable = false)
    private status status;

    // Constructors, getters and setters, and other methods...

    // Getters
    public Long getId() {
        return id;
    }

    public Long getCustId() {
        return custId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getOrderDeliveryStationID() {
        return deliveryID;
    }

    public status getStatus() {
        return status;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setOrderDeliveryId(Long deliveryID) {
        this.deliveryID = deliveryID;
    }

    public void setStatus(status status) {
        this.status = status;
    }
}
