package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository implements OrderRepository{
    public void createOrder(Product product, int quantity){
        System.out.println("Create Order");
    }
}
