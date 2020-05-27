package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.interfaces.IEventOut;
import com.bandtech.eventech.model.V1.EndPoints;
import com.bandtech.eventech.model.V1.Event;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EventService implements IEventOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json ;
    Event event;
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
    public void postForEntity(Event event) {
        template.postForEntity(endPoints.eventPostEndpoint,event,String.class);
    }


    @Override
    public void deleteForEntity(Long eventId) {
        template.delete(endPoints.eventEndpoint,eventId);
    }

    @Override
    public void putForEntity(Long eventId, Event event) {

    }



}
