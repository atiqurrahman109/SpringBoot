package com.emranhss.project.service;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
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
=======
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleEmail(String to,String subject,String body) throws MessagingException {

        MimeMessage  message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body,   true);

        javaMailSender.send(message);

    }

    }


>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
