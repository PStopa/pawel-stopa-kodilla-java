package com.kodilla.good.patterns.add.producer;

public class OrderProcessor {
    public static void main(String[] args) {
        ExtraFoodShopDataAPI extraFoodShopDataAPI = new ExtraFoodShopDataAPI();
        ExtraFoodShopOrderAPI extraFoodShopOrderAPI = new ExtraFoodShopOrderAPI();
        HealthyShopDataAPI healthyShopDataAPI = new HealthyShopDataAPI();
        HealthyShopOrderAPI healthyShopOrderAPI = new HealthyShopOrderAPI();
        GlutenFreeShopDataAPI glutenFreeShopDataAPI = new GlutenFreeShopDataAPI();
        GlutenFreeShopOrderAPI glutenFreeShopOrderAPI = new GlutenFreeShopOrderAPI();

        Product product = new Product("bread", 200);
        OrderRequest orderRequest = new OrderRequest(product);

        Producer extraFoodShop = new Producer(extraFoodShopDataAPI, extraFoodShopOrderAPI);
        Producer healthyShop = new Producer(healthyShopDataAPI, healthyShopOrderAPI);
        Producer glutenFreeShop = new Producer(glutenFreeShopDataAPI, glutenFreeShopOrderAPI);

        extraFoodShop.process(orderRequest);
        System.out.println("---");

        healthyShop.process(orderRequest);
        System.out.println("---");

        glutenFreeShop.process(orderRequest);
        System.out.println("---");
    }
}
