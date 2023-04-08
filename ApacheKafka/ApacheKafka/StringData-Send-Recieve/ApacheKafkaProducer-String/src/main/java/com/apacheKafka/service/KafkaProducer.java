package com.apacheKafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class KafkaProducer {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "TestTopic";

    @PostMapping("/publish/{message}")
    public String kafkaMessage(@PathVariable("message") final String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message Produced: " + message);
        return "Published Successfully... !";
    }

}