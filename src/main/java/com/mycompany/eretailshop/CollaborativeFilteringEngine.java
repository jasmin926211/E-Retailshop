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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollaborativeFilteringEngine extends RecommendationEngine {

    @Override
    public List<Product> generateRecommendations() {
        List<Product> recommendations = new ArrayList<>();

        Set<String> keywords = new HashSet<>();
        for (Product p : history) {
            if (p.getName().toLowerCase().contains("laptop")) {
                keywords.add("laptop");
            } else if (p.getName().toLowerCase().contains("phone")) {
                keywords.add("phone");
            } else if (p.getName().toLowerCase().contains("monitor")) {
                keywords.add("monitor");
            }
        }

        // Dummy recommendations based on keyword tags
        for (String keyword : keywords) {
            switch (keyword) {
                case "laptop":
                    recommendations.add(new Product(301, "Laptop Stand", 29.99));
                    recommendations.add(new Product(302, "Wireless Mouse", 19.99));
                    break;
                case "phone":
                    recommendations.add(new Product(303, "Phone Case", 15.49));
                    recommendations.add(new Product(304, "Portable Charger", 25.00));
                    break;
                case "monitor":
                    recommendations.add(new Product(305, "HDMI Cable", 12.99));
                    recommendations.add(new Product(306, "Monitor Cleaning Kit", 8.99));
                    break;
            }
        }

        return recommendations;
    }
}