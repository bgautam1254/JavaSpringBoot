package com.apacheKafka.service;

import com.apacheKafka.entity.KafkaEntity;
import com.apacheKafka.repository.KafkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {
    @Autowired
    private KafkaRepository kafkaRepository;

    @Override
    public KafkaEntity saveDepartment(KafkaEntity kafkaEntity) {
        return kafkaRepository.save(kafkaEntity);
    }

}
