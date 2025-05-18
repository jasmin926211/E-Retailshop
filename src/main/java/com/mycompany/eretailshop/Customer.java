/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eretailshop;

/**
 *
 * @author Jasminkumar thummar
 */
import java.util.List;

public class Customer {

    private int customerID;
    private String name;
    private String email;
    private String password;
    private Cart cart;
    private RecommendationEngine recommendationEngine = new CollaborativeFilteringEngine();

    public Customer(int id, String name, String email, String password) {
        this.customerID = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = new Cart(id, id);
    }

    public boolean login(String inputEmail, String inputPassword) {
        return this.email.equals(inputEmail) && this.password.equals(inputPassword);
    }

    public void addToCart(Product product) {
        cart.addItem(product);
        recommendationEngine.addToHistory(product);
    }

    public Order checkout() {
        double total = cart.calculateTotal();
        Order order = new Order(this, cart.getItems(), total);
        cart.clearCart();
        return order;
    }

    public List<Product> viewRecommendations() {
        return recommendationEngine.generateRecommendations();
    }

    public String getName() {
        return name;
    }
}
