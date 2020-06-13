package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Repository.IEventRepository;
import com.bandtech.eventech.crosscutting.PilhaObj;
import com.bandtech.eventech.model.V2.TicketJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class HistoryService {

    @Autowired
    private IEventRepository repository;

    private PilhaObj<TicketJPA> history;
    private Integer totalEvent;
    public String createHistoryEvent(){
     repository.getNameEvent();

        return null;
  }

}
