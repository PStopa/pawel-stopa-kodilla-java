package com.kodilla.good.patterns.add.producer;

import java.util.ArrayList;
import java.util.List;

public class HealthyShopDataAPI implements ProducerAPI{
    public String getInformationAboutProducer(){
        return "HealthyShop";
    }
    public List<Product> getInformationAboutProduct(){
        List<Product> list = new ArrayList<>();
        Product product1 = new Product("pasta", 10);
        Product product2 = new Product("milk", 20);
        Product product3 = new Product("bread", 30);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        return list;
    }
}
