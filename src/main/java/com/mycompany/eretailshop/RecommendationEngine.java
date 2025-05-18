package com.mycompany.eretailshop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jasminkumar
 */
public abstract class RecommendationEngine {

    protected List<Product> history = new ArrayList<>();

    public abstract List<Product> generateRecommendations();

    public void addToHistory(Product product) {
        history.add(product);
    }

    public List<Product> getHistory() {
        return new ArrayList<>(history);
    }

    public void clearHistory() {
        history.clear();
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }
}
