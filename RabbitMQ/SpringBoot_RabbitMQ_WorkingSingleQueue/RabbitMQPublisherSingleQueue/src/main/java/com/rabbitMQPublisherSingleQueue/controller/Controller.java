package com.rabbitMQPublisherSingleQueue.controller;

import com.rabbitMQPublisherSingleQueue.Entity.Entity;
import com.rabbitMQPublisherSingleQueue.configuration.Configuration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.Socket;
import java.util.Date;
import java.util.UUID;

@RestController
public class Controller {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Entity message) throws Exception {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(Configuration.EXCHANGE, Configuration.ROUTING_KEY, message);

        String last = "\n\nMessage Published\n--------------------------";
        return portChecker(8082) + last;
    }

    public static String portChecker(int port) throws InterruptedException {
        String s;
        try {
            Socket socket = new Socket("localhost", port);
            s = "Client Server is Up, you can send message.";
            socket.close();
        } catch (Exception e) {
            s = "Client Server is Down, you can still send message." +
                    "\nMessages will be delivered after client comes online...";
        }
        return s;
    }


}


