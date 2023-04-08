package com.rabbitMQConsumerSingleQueue.listenerMessage;

import com.rabbitMQConsumerSingleQueue.configuration.Configuration;
import com.rabbitMQConsumerSingleQueue.entity.Entity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerMessage {
    @RabbitListener(queues = Configuration.QUEUE)
    public void listener(Entity message) {
        System.out.println("Message_Date: " + message.getMessageDate());
        System.out.println("Message_ID: " + message.getMessageId());
        System.out.println("Message: " + message.getMessage());
        System.out.println("-------------------------------------------");
    }
}