package com.kodilla.good.patterns.add.producer;

import java.util.HashMap;

public class GlutenFreeShopDataAPI implements ProducerAPI {
    public String getInformationAboutProducer(){
        return "GlutenFreeShop";
    }
    public HashMap<String, Product> getProduct(){
        HashMap<String, Product> productMap = new HashMap<>();
        Product product1 = new Product("cola", 100);
        Product product2 = new Product("banana", 200);
        Product product3 = new Product("bread", 300);
        productMap.put("cola", product1);
        productMap.put("banana", product2);
        productMap.put("bread", product3);
        return productMap;
    }
}
