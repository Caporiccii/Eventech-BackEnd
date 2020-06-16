package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Repository.ICategoryRepository;
import com.bandtech.eventech.Repository.ICompanyRepository;
import com.bandtech.eventech.Repository.IEventRepository;
import com.bandtech.eventech.Repository.ITicketRepository;
import com.bandtech.eventech.crosscutting.PilhaObj;
import com.bandtech.eventech.interfaces.ICategoryOut;
import com.bandtech.eventech.model.V2.History;
import com.bandtech.eventech.model.V2.TicketJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class HistoryService {

    @Autowired
    private IEventRepository repository;
    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    private History history = new History();
    private PilhaObj<History> historyStack;
    private List<History> historyList;
    private Integer totalEvent;

    public History addHistory(){
        try {
            int count = ticketRepository.getCountTicket();
         String nameEvent = getNameHistoryEvent();
         String nameCompany = getNameHistoryCompany();
         String nameCategory = getNameHistoryCategory();

    for (int i = 0; i < count; i++)
        historyStack.push(history = new
                History(nameEvent, nameCompany, nameCategory));
}catch (Exception ex){
    System.out.println(ex + "Erro ao gerar Historico");
}
    return history;
    }

    public String getNameHistoryEvent(){
        String nameEventQuery = repository.getNameEvent();
        history.setNameEvent(nameEventQuery);
        return nameEventQuery;
  }

    public String getNameHistoryCompany(){
        String nameCompanyQuery = companyRepository.getNameCompany();
        history.setNameCompany(nameCompanyQuery);

        return nameCompanyQuery;
    }

    public String getNameHistoryCategory(){
        String nameCategoryQuery = categoryRepository.getCategoryEvent();
        history.setNameCompany(nameCategoryQuery);

        return nameCategoryQuery;
    }
}
