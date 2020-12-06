package com.bandtech.eventech.Service.V3;

import com.bandtech.eventech.Repository.V3.IEventForMobileRepository;
import com.bandtech.eventech.model.V3.EventForMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SendEmailServiceForMobile {
    @Autowired
    private IEventForMobileRepository eventForMobileRepository;
    private Optional<EventForMobile> eventForMobile;

    public Optional<EventForMobile> getDataForEmail(Integer eventId){

         eventForMobile = eventForMobileRepository.findById(eventId);

        return eventForMobile;
    }
}
