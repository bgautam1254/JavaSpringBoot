package com.apacheKafka.service;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class KafkaConsumer {
    @KafkaListener(topics = "TestTopic", groupId = "group-id")
    public void receiveMessage(String message) {
        System.out.println("Message Received: " + message);
    }

}
