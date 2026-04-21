package com.kafka.consumer.service;


import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class ConsumerService {

    private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "kafka-spring-learn2", groupId = "kafka-learn-group1")
    public void consumeMessage(String msg){
        log.info("Consumer consumed the message: {}", msg);
    }
}
