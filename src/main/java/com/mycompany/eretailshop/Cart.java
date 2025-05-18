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

public class Cart {

    private int cartID;
    private int customerID;
    private List<Product> items;
    private LocalDateTime lastUpdated;

    public Cart(int cartID, int customerID) {
        this.cartID = cartID;
        this.customerID = customerID;
        this.items = new ArrayList<>();
        this.lastUpdated = LocalDateTime.now();
    }

    public void addItem(Product product) {
        items.add(product);
        lastUpdated = LocalDateTime.now();
    }

    public void removeItem(Product product) {
        items.remove(product);
        lastUpdated = LocalDateTime.now();
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public void clearCart() {
        items.clear();
    }

    public List<Product> getItems() {
        return items;
    }
}
