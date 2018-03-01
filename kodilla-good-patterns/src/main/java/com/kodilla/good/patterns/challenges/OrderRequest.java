package com.kodilla.good.patterns.challenges;

public class OrderRequest {
    public Product product;
    public int quantity;
    public User user;

    public OrderRequest(User user, Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }
}
