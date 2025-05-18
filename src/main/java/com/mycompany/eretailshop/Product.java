/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eretailshop;

/**
 *
 * @author Jasminkumar thummar
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private int productID;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
    private String brand;
    private List<String> images;
    private LocalDateTime createdAt;

    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.createdAt = LocalDateTime.now();
        this.images = new ArrayList<>();
    }

    public String getDetails() {
        return productID + " - " + name + ": $" + price;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public boolean isAvailable() {
        return stockQuantity > 0;
    }

    public double getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }
}
