package com.apacheKafka.service;

import com.apacheKafka.entity.KafkaEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "TestTopic", groupId = "group-id", containerFactory = "jsonDataListenerFactory")
    public void receiveMessage(KafkaEntity kafkaEntity) {
        System.out.println("------Message Received------");
        System.out.println("User ID     :" + kafkaEntity.getUserId());
        System.out.println("User Name   :" + kafkaEntity.getUserName());
        System.out.println("----------------------------\n");
    }

}
