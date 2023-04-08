package com.apacheKafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    // -----------------------------------------------------------------------
    // Creating Topic
    // -----------------------------------------------------------------------
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("TestTopic")
        .partitions(1)
        .replicas(1)
        .build();
    }
    // -----------------------------------------------------------------------

}