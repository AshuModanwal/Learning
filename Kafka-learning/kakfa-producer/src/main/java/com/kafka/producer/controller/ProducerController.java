package com.kafka.producer.controller;


import com.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService service;

    @PostMapping("/publish/{msg}")
    public ResponseEntity<?> publishMessageToTopic(@PathVariable String msg){
        try{
            service.publishMessageToTopic(msg);
            return ResponseEntity.ok("message published successfully!");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
