package com.bandtech.eventech.controller.V3;

import com.bandtech.eventech.Repository.V3.IEventForMobileRepository;
import com.bandtech.eventech.model.V3.EventForMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity postEvents(@RequestBody EventForMobile eventForMobile){
        eventForMobileRepository.save(eventForMobile);

        return status(201).build();
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
