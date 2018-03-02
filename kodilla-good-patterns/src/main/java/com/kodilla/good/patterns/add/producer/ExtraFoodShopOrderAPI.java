package com.kodilla.good.patterns.add.producer;

import java.util.HashMap;
import java.util.List;


public class ExtraFoodShopOrderAPI implements OrderService {
    public boolean process(OrderRequest orderRequest) {
        ExtraFoodShopDataAPI api = new ExtraFoodShopDataAPI();

        HashMap<Name, Product> productMap = new HashMap<>();
        for (Product product : api.getProduct()) {
            productMap.put(new Name(product.getName()), product);
        }

        Name nameTmp = new Name(orderRequest.getProduct().getName());
        System.out.println(api.getInformationAboutProducer());
        boolean containsOrder = productMap.containsKey(nameTmp);
        if (containsOrder) {
            Product productTmp = productMap.get(nameTmp);
            if (productTmp.getQuantity() >= orderRequest.getProduct().getQuantity()) {
                System.out.println("Order - succesful!");
                return true;
            }
        }
        System.out.println("Order - fail!");
        return false;
    }
}
