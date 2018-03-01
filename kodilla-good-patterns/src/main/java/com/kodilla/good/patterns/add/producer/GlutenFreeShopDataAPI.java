package com.kodilla.good.patterns.add.producer;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShopDataAPI implements ProducerAPI {
    public String getInformationAboutProducer(){
        return "GlutenFreeShop";
    }
    public List<Product> getInformationAboutProduct(){
        List<Product> list = new ArrayList<>();
        Product product1 = new Product("pasta", 10000);
        Product product2 = new Product("milk", 2000000);
        Product product3 = new Product("bread", 3000000);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        return list;
    }
}
