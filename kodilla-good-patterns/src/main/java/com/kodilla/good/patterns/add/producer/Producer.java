package com.kodilla.good.patterns.add.producer;

import java.util.HashMap;

public class Producer {
    private String name;
    private HashMap<String, Product> productMap;
    private OrderService orderService;
    private ProducerAPI producerAPI;

    public Producer(ProducerAPI producerAPI, OrderService orderService) {
        this.orderService = orderService;
        this.producerAPI = producerAPI;
    }

    public String getName() {
        name = producerAPI.getInformationAboutProducer();
        return name;
    }

    public HashMap<String, Product> getProduct() {
        productMap = producerAPI.getProduct();
        return new HashMap<>(productMap);
    }

    public boolean process(OrderRequest orderRequest){
        return orderService.process(orderRequest);
    }

}
