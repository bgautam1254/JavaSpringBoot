package com.email;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SendEmailApplication {
    @Autowired
    private EmailSenderService service;

    public static void main(String[] args) {
        SpringApplication.run(SendEmailApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        service.sendSimpleEmail(
                "bgautam1991@gmail.com",
                "This is Email Body without Attachment...",
                "This email has no-attachment");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerAttachedMail() throws MessagingException {
        service.sendMailWithAttachment(
                "bgautam1991@gmail.com",
                "This is Email Body with an Attachment...",
                "This email has an attachment",
                "C:\\Users\\Gautam\\Desktop\\git.png");
    }

}
