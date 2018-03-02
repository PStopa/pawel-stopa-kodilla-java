package com.kodilla.good.patterns.add.producer;

import java.util.List;

public class GlutenFreeShopOrderAPI implements OrderService {
    public boolean process(OrderRequest orderRequest) {
        GlutenFreeShopDataAPI api = new GlutenFreeShopDataAPI();
        List<Product> list = api.getProduct();
        boolean result = false;

        System.out.println(api.getInformationAboutProducer());
        int i=0;
        while(i < list.size()) {
            if((list.get(i).getName().equals(orderRequest.getProduct().getName())) &&
                    (list.get(i).getQuantity() >= orderRequest.getProduct().getQuantity())){
                result = true;
            }
            i++;
        }
        if (result){
            System.out.println("Order - succes!");
            return result;
        } else {
            System.out.println("Order - fail!");
            return result;
        }

    }
}