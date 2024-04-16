package com.sc.sc.model;
import jakarta.persistence.*;

@Entity
public class products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Productname")
    private String name;

    @Column
    private int price;

    @Column
    private String pictureUrl;

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStatus(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
