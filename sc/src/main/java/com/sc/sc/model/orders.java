package com.sc.sc.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "expected_delivery_date", nullable = false)
    private LocalDate expectedDeliveryDate;

    @Column(name = "ordered_date", nullable = false)
    private LocalDate orderedDate;


    // Constructors
    public Orders() {
    }
    

    public Orders(Product product, User user, Status status, LocalDate expectedDeliveryDate, LocalDate orderedDate) {
        this.product = product;
        this.user = user;
        this.status = status;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.orderedDate = orderedDate;

    }

    // Getters and setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDate orderedDate) {
        this.orderedDate = orderedDate;
    }

}
