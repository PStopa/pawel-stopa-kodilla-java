package com.kodilla.good.patterns.add.producer;

public class GlutenFreeShopOrderAPI implements OrderService {
    public boolean process(OrderRequest orderRequest) {
        GlutenFreeShopDataAPI api = new GlutenFreeShopDataAPI();
        boolean result = false;

        System.out.println(api.getInformationAboutProducer());
        Product productTmp = api.getProduct().get(orderRequest.getProduct().getName());
        if (productTmp != null) {
            if (productTmp.getQuantity() >= orderRequest.getProduct().getQuantity()) result = true;
        }
        if (result){
            System.out.println("Order - success!");
        } else {
            System.out.println("Order - fail!");
        }
        return result;
    }
}