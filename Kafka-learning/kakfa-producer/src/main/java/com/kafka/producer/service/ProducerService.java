package com.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void publishMessageToTopic(String msg){

        System.out.println("Sending bulk message!....");


        for(int i=1000; i<2000; i++){
            String updatedMsg = msg + "-"+ i;
            CompletableFuture<SendResult<String, Object>>future =  template.send("kafka-spring-learn2",updatedMsg);

            future.whenComplete(((stringObjectSendResult, throwable) -> {
                if(throwable == null){
                    System.out.println("Sent message=["+updatedMsg
                            +"] with offset=["+stringObjectSendResult.getRecordMetadata().offset()
                            +"]");
                }else{
                    System.out.println("Unable to produced message=["+msg + "] due to: "
                            +throwable.getMessage());
                }
            }));
        }

    }
}
