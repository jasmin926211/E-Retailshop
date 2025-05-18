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

public class Order {

    private int orderID;
    private Customer customer;
    private List<Product> items;
    private double total;
    private String status;
    private String paymentMethod;
    private String shippingAddress;
    private LocalDateTime orderDate;

    public Order(Customer customer, List<Product> items, double total) {
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.total = total;
        this.status = "Placed";
        this.orderDate = LocalDateTime.now();
    }

    public void placeOrder() {
        System.out.println("Order placed for customer: " + customer.getName());
        System.out.println("Items ordered:");
        for (Product p : items) {
            System.out.println(" - " + p.getName());
        }
        System.out.println("Total: $" + total);
    }

    public String trackOrder() {
        return status;
    }

    public void cancelOrder() {
        this.status = "Cancelled";
    }

    public double getTotal() {
        return total;
    }
}
