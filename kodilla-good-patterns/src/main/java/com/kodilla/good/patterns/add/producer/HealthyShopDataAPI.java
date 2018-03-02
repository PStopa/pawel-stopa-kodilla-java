package com.kodilla.good.patterns.add.producer;

import java.util.HashMap;

public class HealthyShopDataAPI implements ProducerAPI{
    public String getInformationAboutProducer(){
        return "HealthyShop";
    }
    public HashMap<String, Product> getProduct(){
        HashMap<String, Product> productMap = new HashMap<>();
        Product product1 = new Product("butter", 10);
        Product product2 = new Product("water", 20);
        Product product3 = new Product("bread", 30);
        productMap.put("butter", product1);
        productMap.put("water", product2);
        productMap.put("bread", product3);
        return productMap;
    }
}
