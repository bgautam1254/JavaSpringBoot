package com.apacheKafka.service;

import com.apacheKafka.entity.KafkaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class KafkaProducer {
    @Autowired
    KafkaTemplate<String, KafkaEntity> kafkaTemplate;
    private static final String TOPIC = "TestTopic";

    @PostMapping("/departments")
    public String publishMessage(@RequestBody KafkaEntity kafkaEntity) {
        kafkaTemplate.send(TOPIC, kafkaEntity);
        System.out.println("------Message Sent------");
        System.out.println("User ID     :" + kafkaEntity.getDepartmentId());
        System.out.println("User Name   :" + kafkaEntity.getDepartmentName());
        System.out.println("----------------------------\n");
        return "Published Successfully... !";
    }

}