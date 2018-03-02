package com.kodilla.good.patterns.add.producer;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShopDataAPI implements ProducerAPI {
    public String getInformationAboutProducer(){
        return "ExtraFoodShop";
    }
    public List<Product> getProduct(){
        List<Product> list = new ArrayList<>();
        Product product1 = new Product("pasta", 100);
        Product product2 = new Product("milk", 200);
        Product product3 = new Product("bread", 300);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        return list;
    }
}
