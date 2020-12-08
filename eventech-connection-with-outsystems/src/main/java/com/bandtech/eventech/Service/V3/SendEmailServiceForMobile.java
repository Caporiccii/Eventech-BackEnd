package com.bandtech.eventech.Service.V3;

import com.bandtech.eventech.Repository.V3.IEventForMobileRepository;
import com.bandtech.eventech.model.V3.EventForMobile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class SendEmailServiceForMobile {
    private Logger logger = LogManager.getLogger(SendEmailServiceForMobile.class);
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private IEventForMobileRepository eventForMobileRepository;
    private Optional<EventForMobile> eventForMobileOptional;
    private EventForMobile eventForMobile;
    private String name;
    private String category;
    private String initialDate;
    private String initialHour;
    private SimpleMailMessage email;
    private String cep;
    private BigDecimal price;

    public Optional<EventForMobile> getDataForEmail(Integer eventId){
try {
    eventForMobileOptional = eventForMobileRepository.findById(eventId);
    logger.info(" Dados capturados com sucesso!");
    return eventForMobileOptional;
}
catch (Exception exception){
    logger.info(exception + "Erro ao capturar dados!");
    return eventForMobileOptional;
}


    }

    public EventForMobile mountEmailData (Integer eventId){
     name = getDataForEmail(eventId).get().name;
     category = getDataForEmail(eventId).get().category;
     cep = getDataForEmail(eventId).get().cep;
     price = getDataForEmail(eventId).get().price;
     initialDate = getDataForEmail(eventId).get().initialDate;
     initialHour = getDataForEmail(eventId).get().initialHour;

     eventForMobile = new EventForMobile(name,price,category, cep, initialHour ,initialDate);

     return eventForMobile;
    }



    public void sendEmail(Integer eventId){
        getDataForEmail(eventId);
        mountEmailData(eventId);
        email = new SimpleMailMessage();
try {
        email.setTo("eventech.band@gmail.com");
        email.setText("\"Olá, a Eventec vem lhe informar sobre um novo evento, que pode ser de seu interesse.\"\n" +
                "\n" +
                "\n" +
                "Nome do evento: " + name + "\n" +
                "Categoria do evento: " + category + " \n" +
                "Data e hora de início: " + initialDate + " às " + initialHour+  "\n" +
                "Local: "+cep+" \n" +
                "Valor do ingresso: R$:"+price+"\n" +
                "\n" +
                "" +
                "\n" +
                "Obrigado,\n" +
                "Eventec");
        email.setSubject("Evento Imperdivel!");
        mailSender.send(email);
        logger.debug("Envio de email realizado com sucesso!");
    }catch (Exception exception){
    logger.error(exception + " Não foi possivel realizar o envio do email!");
}
    }


}
