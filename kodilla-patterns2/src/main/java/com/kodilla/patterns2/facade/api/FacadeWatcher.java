package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(orderDto, userId) && target(object)")
    public void logEvent(OrderDto orderDto, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: userId (" + userId + "), itemsId (" +
                orderDto.getItems().stream().map(n -> n.getProductId().toString()).collect(Collectors.joining(" ,")) + ")");
    }
}
