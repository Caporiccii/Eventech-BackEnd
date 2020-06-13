package com.bandtech.eventech.Service;

import com.bandtech.eventech.Repository.IAdressRepository;
import com.bandtech.eventech.Repository.ICategoryRepository;
import com.bandtech.eventech.Repository.IEventJPA;
import com.bandtech.eventech.Repository.ITicketRepository;
import com.bandtech.eventech.model.V2.EventJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ServiceEmailSend {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private IEventJPA eventJPA;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IAdressRepository adressRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    private String name;
    private String category;
    private SimpleMailMessage email;
    private String street;
    private Integer streetNumber;
    private Double price;

    public void sendEmail(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateHour = DateTimeFormatter
        .ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(dateHour);
        streetNumber = adressRepository.getStreetNumber();
        street = adressRepository.getStreet();
        name = eventJPA.getNameEvent();
        category = categoryRepository.getCategoryEvent();
        price = ticketRepository.getPrice();
        email = new SimpleMailMessage();

    try {

        email.setTo("dmarco792@gmail.com");
        email.setText("\"Olá, a Eventech vem lhe informar sobre um novo evento, que pode ser de seu interesse.\"\n" +
                "\n" +
                "\n" +
                "Nome do evento: " + name + "\n" +
                "Categoria do evento: " + category + " \n" +
                "Data e hora de início: " + formattedDate + "\n" +
                "Local: "+street+" "+streetNumber+"\n" +
                "Valor do ingresso: R$:"+price+"\n" +
                "\n" +
                "Se for do seu interesse clique no link para mais informações. <a>asdsa</a>\n" +
                "\n" +
                "Obrigado,\n" +
                "Eventech");
        email.setSubject("Evento Imperdivel!");
        mailSender.send(email);

    }
    catch (Exception ex){
        System.out.println("Não foi possivel realizar o envio do email erro: " + ex);
    }
    }
}
