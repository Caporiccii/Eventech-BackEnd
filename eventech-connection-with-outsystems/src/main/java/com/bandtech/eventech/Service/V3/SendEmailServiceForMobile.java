package com.bandtech.eventech.Service.V3;

import com.bandtech.eventech.Repository.V3.IEventForMobileRepository;
import com.bandtech.eventech.model.V3.EventForMobile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SendEmailServiceForMobile {
    private Logger logger = LogManager.getLogger(SendEmailServiceForMobile.class);
    @Autowired
    private IEventForMobileRepository eventForMobileRepository;
    private Optional<EventForMobile> eventForMobile;
    private String name;
    private String category;
    private String formattedDate;
    private SimpleMailMessage email;
    private String street;
    private Double price;

    public Optional<EventForMobile> getDataForEmail(Integer eventId){

         eventForMobile = eventForMobileRepository.findById(eventId);

        return eventForMobile;
    }

    public void sendEmail (Integer eventId){

    }
}
