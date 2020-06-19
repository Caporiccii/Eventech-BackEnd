package com.bandtech.eventech.Service;

import com.bandtech.eventech.Repository.IAdressRepository;
import com.bandtech.eventech.Repository.ICategoryRepository;
import com.bandtech.eventech.Repository.IEventRepository;
import com.bandtech.eventech.Repository.ITicketRepository;
import com.bandtech.eventech.Service.V1.EventService;
import com.bandtech.eventech.Service.V2.DateFormatService;
import com.bandtech.eventech.model.V1.Event;
import com.bandtech.eventech.model.V1.EventMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ServiceEmailSend {
    @Autowired
    private JavaMailSender mailSender;

    EventService eventService = new EventService();
    private EventMail eventMail;

    private DateFormatService formatService = new DateFormatService();
    private String name;
    private String category;
    private String formattedDate;
    private SimpleMailMessage email;
    private String street;
    private Double price;

    public EventMail GetDataEvent(Long id){
        eventMail = new EventMail();

        eventMail = eventService.getEmailForEntity(id);

        return eventMail;
    }

    public void sendEmail(Long eventId){
       formattedDate = formatService.formatDate();
       street = GetDataEvent(eventId).getAddress();
        name = GetDataEvent(eventId).getName();
        category = GetDataEvent(eventId).getCategory();
        price = GetDataEvent(eventId).getPrice();
        email = new SimpleMailMessage();

    try {

        email.setTo("dmarco792@gmail.com");
        email.setText("\"Olá, a Eventech vem lhe informar sobre um novo evento, que pode ser de seu interesse.\"\n" +
                "\n" +
                "\n" +
                "Nome do evento: " + name + "\n" +
                "Categoria do evento: " + category + " \n" +
                "Data e hora de início: " + formattedDate + "\n" +
                "Local: "+street+" \n" +
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
