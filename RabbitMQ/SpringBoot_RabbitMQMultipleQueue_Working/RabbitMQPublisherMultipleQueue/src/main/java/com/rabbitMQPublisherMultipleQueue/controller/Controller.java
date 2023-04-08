package com.rabbitMQPublisherMultipleQueue.controller;

import com.rabbitMQPublisherMultipleQueue.Entity.Entity;
import com.rabbitMQPublisherMultipleQueue.configuration.Configuration;
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

    // Publishing json data
    @PostMapping("/publish")
    public String publishMessageJson(@RequestBody Entity message) throws Exception {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(Configuration.EXCHANGE, Configuration.JSON_ROUTING_KEY, message);

        String last = "\n\nJson Message Published\n--------------------------";
        return portChecker(8082) + last;
    }

    // Publishing String data
    @PostMapping("/publish1")
    public String publishMessageString(@RequestBody String message) throws Exception {
        template.convertAndSend(Configuration.EXCHANGE, Configuration.ROUTING_KEY, message);

        String last = "\n\nString Message Published\n--------------------------";
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


