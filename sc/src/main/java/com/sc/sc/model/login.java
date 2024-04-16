package com.sc.sc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;
    
    @Enumerated(EnumType.STRING)
    private role role;

    @Column(unique = true)
    private String email;

    private String password;

    // Constructors, getters and setters, and other methods...

    public role getrole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setrole(role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
