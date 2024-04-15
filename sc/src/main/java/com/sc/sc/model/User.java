package com.sc.sc.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;

    @OneToOne
    private login login;

    @OneToMany
    private List<Order> orders;

    // Constructors, getters and setters, and other methods...

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public login getlogin() {
        return login;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setlogin(login login) {
        this.login = login;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
