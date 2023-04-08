package com.rabbitMQConsumerMultipleQueue.listenerMessage;

import com.rabbitMQConsumerMultipleQueue.configuration.Configuration;
import com.rabbitMQConsumerMultipleQueue.entity.Entity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerMessage {
    @RabbitListener(queues = Configuration.QUEUE)
    public void listenerString(String message) {
        System.out.println("String Message: " + message);
        System.out.println("-------------------------------------------");
    }

    @RabbitListener(queues = Configuration.JSON_QUEUE)
    public void listenerJson(Entity message) {
        System.out.println("Message_Date: " + message.getMessageDate());
        System.out.println("Message_ID: " + message.getMessageId());
        System.out.println("Message: " + message.getMessage());
        System.out.println("-------------------------------------------");
    }
}