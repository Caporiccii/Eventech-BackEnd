package com.bandtech.eventech.controller.V3;

import com.bandtech.eventech.Repository.ITicketRepository;
import com.bandtech.eventech.Repository.V3.IEventForMobileRepository;
import com.bandtech.eventech.model.V1.Ticket;
import com.bandtech.eventech.model.V2.TicketJPA;
import com.bandtech.eventech.model.V3.EventForMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v3/event")
public class EventControllerForMobile {
@Autowired
private IEventForMobileRepository eventForMobileRepository;

    @GetMapping
    public ResponseEntity getEvents(){
        List<EventForMobile> eventForMobile = eventForMobileRepository.findAll();
        if (eventForMobile.isEmpty())
            return noContent().build();
        else
            return ok(eventForMobile);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity getEventsById(@PathVariable("eventId") int eventId){
        Optional<EventForMobile> eventForMobile = eventForMobileRepository.findById(eventId);
        if (!eventForMobile.isPresent())
            return badRequest().build();
        else
            return ok(eventForMobile);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getEventsByUser(@PathVariable("userId") int userId){
        List<EventForMobile> eventForMobile = eventForMobileRepository.getEventsByUser(userId);
        if (eventForMobile.isEmpty())
            return noContent().build();
        else
            return ok(eventForMobile);
    }

    @PostMapping
    public ResponseEntity postEvents(@RequestBody EventForMobile eventForMobile){
        eventForMobileRepository.save(eventForMobile);

        return status(201).body(eventForMobile.idEventMobile);
      }

    @DeleteMapping("/{eventId}")
    public ResponseEntity deleteEventById(@PathVariable("eventId") int eventId){
        if (this.eventForMobileRepository.existsById(eventId)) {
            this.eventForMobileRepository.deleteById(eventId);
            return ok().build();
        }
        else{
            return notFound().build();

        }
    }
}
