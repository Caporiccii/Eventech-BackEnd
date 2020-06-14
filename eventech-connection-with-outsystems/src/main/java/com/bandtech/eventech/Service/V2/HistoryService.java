package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Repository.ICategoryRepository;
import com.bandtech.eventech.Repository.ICompanyRepository;
import com.bandtech.eventech.Repository.IEventRepository;
import com.bandtech.eventech.crosscutting.PilhaObj;
import com.bandtech.eventech.interfaces.ICategoryOut;
import com.bandtech.eventech.model.V2.TicketJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HistoryService {

    @Autowired
    private IEventRepository repository;
    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    private PilhaObj<String> history;
    private Integer totalEvent;

    public String addHistory(){
        String nameEvent = getNameHistoryEvent();


        //for (String a : nameEvent)
        return null;
    }

    public String getNameHistoryEvent(){
     String name = repository.getNameEvent();
     history.push(name);
     return history.peek();
  }

    public String getNameHistoryCompany(){
        String nameCompany = companyRepository.getNameCompany();
        history.push(nameCompany);
        return history.peek();
    }

    public String getNameHistoryCategory(){
        String nameCategory = categoryRepository.getCategoryEvent();
        history.push(nameCategory);
        return history.peek();
    }
}
