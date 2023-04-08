package com.rabbitMQConsumerMultipleQueue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity {
    private Date messageDate;
    private String messageId;
    private String message;

}
