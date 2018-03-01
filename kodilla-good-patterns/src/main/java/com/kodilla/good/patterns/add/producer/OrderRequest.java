package com.kodilla.good.patterns.add.producer;

public class OrderRequest {
    private Product product;

    public OrderRequest(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
