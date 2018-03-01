package com.kodilla.good.patterns.add.producer;

import java.util.List;


public class ExtraFoodShopOrderAPI implements OrderService{
    public boolean process(OrderRequest orderRequest) {
        ExtraFoodShopDataAPI api = new ExtraFoodShopDataAPI();
        List<Product> list = api.getInformationAboutProduct();

        for (Product productTmp : list) {
            if ((productTmp.getName() == orderRequest.getProduct().getName()) &&
                    (productTmp.getQuantity() >= orderRequest.getProduct().getQuantity())) {

                System.out.println(api.getInformationAboutProducer());
                System.out.println("Order - succesful!");
                return true;
            }
        }
        System.out.println("Order - fail!");
        return false;
    }
}
