package com.bandtech.eventech.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ServiceEmailSend {
    @Autowired
    private JavaMailSender mailSender;
    private SimpleMailMessage email;
    public void sendEmail(){
         email = new SimpleMailMessage();
        email.setTo("eventech.band@gmail.com");
        email.setSubject("Teste envio de e-mail");
        email.setText("Enviei este e-mail usando Spring Boot.");
        mailSender.send(email);
    }
}
