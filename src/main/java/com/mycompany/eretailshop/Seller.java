/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eretailshop;

/**
 *
 * @author Jasminkumar thummar
 */
import java.util.ArrayList;
import java.util.List;

public class Seller {

    private int sellerID;
    private String name;
    private String email;
    private String storeName;
    private List<Product> productList;
    private String password;

    public Seller(int sellerID, String name, String email, String password, String storeName) {
        this.sellerID = sellerID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.storeName = storeName;
        this.productList = new ArrayList<>();
    }

    public boolean login(String inputEmail, String inputPassword) {
        return this.email.equalsIgnoreCase(inputEmail) && this.password.equals(inputPassword);
    }

    // Add a new product
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product " + product.getName() + " added to store.");
    }

    // Remove product by productID
    public boolean removeProduct(int productID) {
        for (Product p : productList) {
            if (p.getProductID() == productID) {
                productList.remove(p);
                System.out.println("Product " + p.getName() + " removed from store.");
                return true;
            }
        }
        System.out.println("Product ID " + productID + " not found.");
        return false;
    }

    // Update product price by productID
    public boolean updateProductPrice(int productID, double newPrice) {
        for (Product p : productList) {
            if (p.getProductID() == productID) {
                p.updatePrice(newPrice);
                System.out.println("Product " + p.getName() + " price updated to $" + newPrice);
                return true;
            }
        }
        System.out.println("Product ID " + productID + " not found.");
        return false;
    }

    // View all products in seller's store
    public void viewProducts() {
        System.out.println("Products in store '" + storeName + "':");
        for (Product p : productList) {
            System.out.println(p.getDetails());
        }
    }

    // Getters (optional)
    public String getName() {
        return name;
    }

    public String getStoreName() {
        return storeName;
    }
}
