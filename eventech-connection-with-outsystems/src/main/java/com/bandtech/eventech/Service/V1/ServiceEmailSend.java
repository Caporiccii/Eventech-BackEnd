package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.Service.V2.DateFormatService;
import com.bandtech.eventech.model.V1.EventMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ServiceEmailSend {
    @Autowired
    private JavaMailSender mailSender;

    private Logger logger = LogManager.getLogger(ServiceEmailSend.class);

    private DateFormatService formatService = new DateFormatService();
    EventService eventService = new EventService();

    private EventMail eventMail;
    private String name;
    private String category;
    private String formattedDate;
    private SimpleMailMessage email;
    private String street;
    private Double price;

    public EventMail GetDataEvent(Long id){
        try {
            eventMail = new EventMail();

            eventMail = eventService.getEmailForEntity(id);
            logger.info(eventMail + " Dados capturados com sucesso!");
            return eventMail;
        }
        catch (Exception exception){
            logger.info(exception + "Erro ao capturar dados!");
            return eventMail;
        }
        }

    public void sendEmail(Long eventId){

         formattedDate = formatService.formatDate();
         street = GetDataEvent(eventId).getAddress();
        name = GetDataEvent(eventId).getName();
        category = GetDataEvent(eventId).getCategory();
        price = GetDataEvent(eventId).getPrice();
        email = new SimpleMailMessage();

    try {

        email.setTo("eventech.band@gmail.com");
        email.setText("\"Olá, a Eventech vem lhe informar sobre um novo evento, que pode ser de seu interesse.\"\n" +
                "\n" +
                "\n" +
                "Nome do evento: " + name + "\n" +
                "Categoria do evento: " + category + " \n" +
                "Data e hora de início: " + formattedDate + "\n" +
                "Local: "+street+" \n" +
                "Valor do ingresso: R$:"+price+"\n" +
                "\n" +
                "" +
                "\n" +
                "Obrigado,\n" +
                "Eventech");
        email.setSubject("Evento Imperdivel!");
        mailSender.send(email);
        logger.debug("Envio de email realizado com sucesso!");
    }
    catch ( Exception ex){
        logger.error(ex + " Não foi possivel realizar o envio do email!");
    }
    }
}
