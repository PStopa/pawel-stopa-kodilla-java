package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("John", "Kowalsky");
        Product product = new Product("Scrabble");
        int quantity = 1;

        return new OrderRequest(user, product, quantity);
    }
}
