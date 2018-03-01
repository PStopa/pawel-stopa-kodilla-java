package com.kodilla.good.patterns.add.producer;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    private String name;
    private List<Product> list;
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

    public List<Product> getProduct() {
        list = producerAPI.getInformationAboutProduct();
        return new ArrayList<>(list);
    }

    public boolean process(OrderRequest orderRequest){
        boolean result = orderService.process(orderRequest);
        return result;
    }

}
