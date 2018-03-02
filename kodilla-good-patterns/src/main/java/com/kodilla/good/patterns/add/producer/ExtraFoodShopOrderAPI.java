package com.kodilla.good.patterns.add.producer;

public class ExtraFoodShopOrderAPI implements OrderService {
    public boolean process(OrderRequest orderRequest) {
        ExtraFoodShopDataAPI api = new ExtraFoodShopDataAPI();

        System.out.println(api.getInformationAboutProducer());
        Product productTmp = api.getProduct().get(orderRequest.getProduct().getName());
        if (productTmp != null) {
            if (productTmp.getQuantity() >= orderRequest.getProduct().getQuantity()) {
                System.out.println("Order - success!");
                return true;
            }
        }
        System.out.println("Order - fail!");
        return false;
    }
}
