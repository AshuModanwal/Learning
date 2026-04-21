package com.kafka.producer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("kafka-spring-learn2", 3, (short) 1);
    }

}
