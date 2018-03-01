package com.kodilla.good.patterns.add.producer;

public interface OrderService {
    boolean process(OrderRequest orderRequest);
}
