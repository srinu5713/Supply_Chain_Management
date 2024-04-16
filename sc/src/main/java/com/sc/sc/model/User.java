package com.sc.sc.model;

import jakarta.persistence.*;
// import java.util.List;

@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private login login;

    private String address;

    private String name;

    // Getters
    public Long getId() {
        return id;
    }

    public login getlogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setlogin(login login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
