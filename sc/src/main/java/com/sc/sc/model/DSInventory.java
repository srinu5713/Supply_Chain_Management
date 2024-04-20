package com.sc.sc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "ds_inventory")
public class DSInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @Enumerated(EnumType.STRING)
    private DSInventoryStatus status;

    private int quantity;

    // Constructors
    public DSInventory() {
    }

    public DSInventory(Orders order, DSInventoryStatus status, int quantity) {
        this.order = order;
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

    public Orders getorder() {
        return order;
    }

    public void setproduct(Orders order) {
        this.order = order;
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
