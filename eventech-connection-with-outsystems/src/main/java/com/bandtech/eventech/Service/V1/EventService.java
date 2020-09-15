package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.interfaces.IEventOut;
import com.bandtech.eventech.model.V1.EndPoints;
import com.bandtech.eventech.model.V1.Event;
import com.bandtech.eventech.model.V1.EventMail;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class EventService implements IEventOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json ;
    Event event;
    EventMail eventMail;
    ResponseEntity<String> response;

    @Override
    public Event getForEntity(Long eventId) {

        response = template.getForEntity(endPoints.eventEndpoint , String.class, eventId);
        try {
            json = new JSONObject(response.getBody());
        }
        catch (Exception e){
            //logar a exception!!
            System.out.println(e);
        }
    event = new Event(json);

        return event;
    }

    @Override
    public Event getForEntityV2(Long eventId) {



        return null;
    }

    public EventMail getEmailForEntity(Long eventId) {
        response = template.getForEntity(endPoints.eventEndpointEmail , String.class, eventId);
        try {
            json = new JSONObject(response.getBody());
        }
        catch (Exception e){
            //logar a exception!!
            System.out.println(e);
        }
        eventMail = new EventMail(json);


        return eventMail;
    }

    @Override
    public List<String> getEventList() {
        List<String> list = new ArrayList<>();
        response = template.getForEntity(endPoints.eventEndpointV2List, String.class);

        list.add(response.toString());

        return list;
    }

    @Override
    public void postForEntity(Event event) {
        template.postForEntity(endPoints.eventPostEndpoint,event,String.class);
    }


    @Override
    public void deleteForEntity(Long eventId) {
        template.delete(endPoints.eventEndpoint,eventId);
    }

    @Override
    public void putForEntity(Long eventId, Event event) {
          template.put(endPoints.eventEndpoint, event, eventId);
    }



}
