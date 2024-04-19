package com.sc.sc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private double price;

    @Column(name = "picture_url", nullable = false)
    private String pictureUrl;

    // Constructors
    public product() {
    }

    public product(String productName, double price, String pictureUrl) {
        this.productName = productName;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    // Getters and setters
    public Long getproductId() {
        return productId;
    }

    public void setproductId(Long productId) {
        this.productId = productId;
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}