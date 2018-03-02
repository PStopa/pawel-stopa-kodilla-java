package com.kodilla.good.patterns.add.producer;

public class HealthyShopOrderAPI implements OrderService {
    public boolean process(OrderRequest orderRequest) {
        HealthyShopDataAPI api = new HealthyShopDataAPI();

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
