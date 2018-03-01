package com.kodilla.good.patterns.challenges;

public class ProductOrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderProcessor(InformationService informationService,
                                 OrderService orderService,
                                 OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process (final OrderRequest orderRequest) {
        boolean isOrder = orderService.order(orderRequest.getProduct(), orderRequest.getQuantity());
        if(isOrder) {
            informationService.inform();
            orderRepository.createOrder(orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
        }
    }
}
