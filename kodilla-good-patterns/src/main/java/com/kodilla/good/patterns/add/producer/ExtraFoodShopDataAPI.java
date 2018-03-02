package com.kodilla.good.patterns.add.producer;

import java.util.HashMap;

public class ExtraFoodShopDataAPI implements ProducerAPI {
    public String getInformationAboutProducer(){
        return "ExtraFoodShop";
    }
    public HashMap<String, Product> getProduct(){
        HashMap<String, Product> productMap = new HashMap<>();
        Product product1 = new Product("pasta", 100);
        Product product2 = new Product("milk", 200);
        Product product3 = new Product("bread", 300);
        productMap.put("pasta", product1);
        productMap.put("milk", product2);
        productMap.put("bread", product3);
        return productMap;
    }
}
