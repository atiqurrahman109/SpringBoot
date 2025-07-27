package com.emranhss.project.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender JavaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;

    }

    public void sendSimpleEmail(String to,String subject,String body)
            throws MessagingException{

        MimeMe





    }
}
