package com.apacheKafka.controller;

import com.apacheKafka.entity.KafkaEntity;
import com.apacheKafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class KafkaController {
    @Autowired
    private KafkaService kafkaService;

    @KafkaListener(topics = "TestTopic", groupId = "group-id", containerFactory = "jsonDataListenerFactory")
    public void saveDepartment(KafkaEntity kafkaEntity) {
        kafkaService.saveDepartment(kafkaEntity);
        System.out.println("------Message Received------");
        System.out.println("User ID     :" + kafkaEntity.getDepartmentId());
        System.out.println("User Name   :" + kafkaEntity.getDepartmentName());
        System.out.println("----------------------------\n");
    }

//    @KafkaListener(topics = "TestTopic", groupId = "group-id", containerFactory = "jsonDataListenerFactory")
//    public KafkaEntity saveDepartment(KafkaEntity kafkaEntity) {
//        System.out.println("------Message Received------");
//        System.out.println("User ID     :" + kafkaEntity.getDepartmentId());
//        System.out.println("User Name   :" + kafkaEntity.getDepartmentName());
//        System.out.println("----------------------------\n");
//        return kafkaService.saveDepartment(kafkaEntity);
//    }


}

