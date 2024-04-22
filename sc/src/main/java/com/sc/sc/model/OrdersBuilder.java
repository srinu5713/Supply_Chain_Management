// OrdersBuilder class to construct Orders objects
package com.sc.sc.model;

import java.time.LocalDate;

public class OrdersBuilder {
    private Product product;
    private User user;
    private Status status;
    private Long quantity;
    private LocalDate expectedDeliveryDate;
    private LocalDate orderedDate;

    public OrdersBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrdersBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public OrdersBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public OrdersBuilder setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrdersBuilder setExpectedDeliveryDate(LocalDate date) {
        this.expectedDeliveryDate = date;
        return this;
    }

    public OrdersBuilder setOrderedDate(LocalDate date) {
        this.orderedDate = date;
        return this;
    }

    public Orders build() {
        return new Orders(product, user, status, quantity, expectedDeliveryDate, orderedDate);
    }
}