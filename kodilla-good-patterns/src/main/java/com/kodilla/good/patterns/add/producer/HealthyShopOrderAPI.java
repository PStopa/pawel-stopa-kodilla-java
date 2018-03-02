package com.kodilla.good.patterns.add.producer;

import java.util.List;

public class HealthyShopOrderAPI implements OrderService {
    public boolean process(OrderRequest orderRequest) {
        HealthyShopDataAPI api = new HealthyShopDataAPI();
        List<Product> list = api.getProduct();

        System.out.println(api.getInformationAboutProducer());
        if(list.contains(orderRequest.getProduct())){
            int index = list.indexOf(orderRequest.getProduct());
            if(list.get(index).getQuantity() >= orderRequest.getProduct().getQuantity()){
                System.out.println("Order - success!");
                return true;
            }
        }
        System.out.println("Order - fail!");
        return false;
    }
}
