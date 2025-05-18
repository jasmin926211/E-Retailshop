/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.eretailshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jasminkumar thummar
 */
public class ERetailShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Product> demoProducts = new ArrayList<>();
        
        demoProducts.add(new Product(201, "Wireless Mouse", 25.99));
        demoProducts.add(new Product(202, "Bluetooth Speaker", 45.00));
        demoProducts.add(new Product(203, "Gaming Monitor", 189.50));
        demoProducts.add(new Product(204, "USB-C Hub", 29.99));
        demoProducts.add(new Product(205, "External SSD 1TB", 109.99));
        demoProducts.add(new Product(206, "Smart Watch", 149.99));
        demoProducts.add(new Product(207, "Webcam HD", 39.99));
        demoProducts.add(new Product(208, "Portable Charger", 34.99));
        demoProducts.add(new Product(209, "Noise Cancelling Earbuds", 79.95));
        demoProducts.add(new Product(210, "Laptop Stand", 22.49));
         
        // Demo products (global catalog)
        List<Product> productCatalog = new ArrayList<>();
        productCatalog.add(new Product(101, "Laptop", 999.99));
        productCatalog.add(new Product(102, "Smartphone", 499.49));
        productCatalog.add(new Product(103, "Headphones", 89.99));
        productCatalog.add(new Product(104, "Keyboard", 39.99));

        // Demo customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", "john@example.com", "password123"));
        customers.add(new Customer(2, "Jane Smith", "jane@example.com", "mypassword"));

        // Demo merchants
        List<Seller> merchants = new ArrayList<>();
        Seller alice = new Seller(1, "Alice", "alice@shop.com", "alicepass123", "Alice's Tech Store");
        merchants.add(alice);

        System.out.println("Welcome! Are you a Customer or Merchant? (Enter C for Customer, M for Merchant):");
        String userType = scanner.nextLine().trim().toUpperCase();

        if (userType.equals("M")) {
            // Merchant login
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            Seller loggedInMerchant = null;
            for (Seller s : merchants) {
                if (s.login(email, password)) {
                    loggedInMerchant = s;
                    break;
                }
            }

            if (loggedInMerchant != null) {
                System.out.println("Welcome, " + loggedInMerchant.getName() + "!");

                boolean exit = false;
                while (!exit) {
                    System.out.println("\nMerchant Menu - Choose an option:");
                    System.out.println("1. Add Product");
                    System.out.println("2. Edit Product Price");
                    System.out.println("3. Delete Product");
                    System.out.println("4. View Products");
                    System.out.println("5. Logout");
                    System.out.print("Your choice: ");

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.println("Enter new product ID:");
                            int newId = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter product name:");
                            String newName = scanner.nextLine();
                            System.out.println("Enter product price:");
                            double newPrice = Double.parseDouble(scanner.nextLine());
                            Product newProduct = new Product(newId, newName, newPrice);
                            loggedInMerchant.addProduct(newProduct);
                            break;
                        case 2:
                            System.out.println("Enter product ID to update price:");
                            int updateId = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter new price:");
                            double updatePrice = Double.parseDouble(scanner.nextLine());
                            loggedInMerchant.updateProductPrice(updateId, updatePrice);
                            break;
                        case 3:
                            System.out.println("Enter product ID to delete:");
                            int deleteId = Integer.parseInt(scanner.nextLine());
                            loggedInMerchant.removeProduct(deleteId);
                            break;
                        case 4:
                            loggedInMerchant.viewProducts();
                            break;
                        case 5:
                            exit = true;
                            System.out.println("Logged out.");
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
            } else {
                System.out.println("Merchant login failed.");
            }
        } else if (userType.equals("C")) {
            // Customer login flow (existing)
            System.out.println("Customer Login");
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            Customer loggedIn = null;
            for (Customer c : customers) {
                if (c.login(email, password)) {
                    loggedIn = c;
                    break;
                }
            }

            if (loggedIn != null) {
                System.out.println("Login successful for: " + loggedIn.getName());

                System.out.println("Available Products:");
                for (Product p : productCatalog) {
                    System.out.println(p.getDetails());
                }

                while (true) {
                    System.out.println("Enter product ID to add to cart (0 to checkout):");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (id == 0) {
                        break;
                    }

                    boolean found = false;
                    for (Product p : productCatalog) {
                        if (p.getProductID() == id) {
                            loggedIn.addToCart(p);
                            System.out.println(p.getName() + " added to cart.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product ID not found.");
                    }
                }

                System.out.println("Proceeding to checkout...");
                Order order = loggedIn.checkout();

                System.out.println("Choose payment method (1. Credit Card, 2. PayPal):");
                int choice = Integer.parseInt(scanner.nextLine());
                Payment payment;
                if (choice == 1) {
                    payment = new CreditCardPayment();
                } else {
                    payment = new PayPalPayment();
                }

                if (payment.processPayment(order.getTotal())) {
                    order.placeOrder();
                } else {
                    System.out.println("Payment failed. Try again.");
                }
            } else {
                System.out.println("Login failed. Incorrect email or password.");
            }
        } else {
            System.out.println("Invalid option selected. Exiting.");
        }

        scanner.close();
    }
}
