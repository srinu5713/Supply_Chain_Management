package com.sc.sc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role type;

    private String address;

    @Column(name = "mobile_number")
    private String mobileNumber;

    // Constructors
    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(String username, String password, Role type, String address, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getType() {
        return type;
    }

    public void setType(Role type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
