package com.kodilla.good.patterns.add.producer;

import java.util.HashMap;

public interface ProducerAPI {
    String getInformationAboutProducer();
    HashMap<String, Product> getProduct();
}
