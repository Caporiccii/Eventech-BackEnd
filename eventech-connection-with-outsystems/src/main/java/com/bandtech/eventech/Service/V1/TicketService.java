package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.interfaces.ITicketOut;
import com.bandtech.eventech.model.V1.EndPoints;
import com.bandtech.eventech.model.V1.Ticket;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TicketService implements ITicketOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json ;
    Ticket ticket;
    ResponseEntity<String> response;
    boolean isReturn = true;
    @Override
    public Ticket getForEntity(Long ticketId) {

        response = template.getForEntity(endPoints.ticketEndpoint,
                String.class,ticketId);
        try {
            json = new JSONObject(response.getBody());
        }
        catch (Exception e){
            //logar a exception!!
            System.out.println(e);
        }

        ticket = new Ticket(json,isReturn);

        return ticket;
    }

    @Override
    public void postForEntity(Ticket ticket) {
          template.postForEntity(endPoints.ticketPostEndpoint,
               ticket,String.class);
    }

    @Override
    public void deleteForEntity(Long ticketId) {
               template.delete(endPoints.ticketEndpoint,ticketId);
    }

    @Override
    public void putForEntity(Long ticketId, Ticket ticket) {

    }
}
