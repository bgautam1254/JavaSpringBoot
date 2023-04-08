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
    // 1st method
    // -----------------------------------------------------------------------
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("TestTopic")
        .partitions(1)
        .replicas(1)
        .build();
    }
    // -----------------------------------------------------------------------


    
    // -----------------------------------------------------------------------
    // 2nd method
    // -----------------------------------------------------------------------
    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topics() {
        return TopicBuilder.name("TestTopic")
                .partitions(1)
                .replicas(1)
                .build();
    }
    // -----------------------------------------------------------------------

}