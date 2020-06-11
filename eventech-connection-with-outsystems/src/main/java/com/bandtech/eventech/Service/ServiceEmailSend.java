package com.bandtech.eventech.Service;

import com.bandtech.eventech.model.V2.EventJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ServiceEmailSend {
    @Autowired
    private JavaMailSender mailSender;
    private EventJPA eventJPA;
    private SimpleMailMessage email;
    public void sendEmail(){
    eventJPA = new EventJPA();
    String nome = eventJPA.getName();
         email = new SimpleMailMessage();
        email.setTo("dmarco792@gmail.com");
        email.setText("\"Olá, a Eventech vem lhe informar sobre um novo evento, que pode ser de seu interesse.\"\n" +
                "\n" +
                "\n" +
                "Nome do evento: "+nome+"\n" +
                "Categoria do evento: (categoria Evento)\n" +
                "Data e hora de início: (data e hora de início)\n" +
                "Local: (local com endereço)\n" +
                "Valor do ingresso:(valorIngresso)\n" +
                "\n" +
                "Se for do seu interesse clique no link para mais informações. <Link>\n" +
                "\n" +
                "Obrigado,\n" +
                "Eventech");
        email.setSubject("Evento Imperdivel!");
        mailSender.send(email);
    }
}
