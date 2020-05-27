package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.EventService;
import com.bandtech.eventech.model.V1.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/events")
public class EventController {

    EventService eventService = new EventService();
    Event response;

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getForEntity(@PathVariable("eventId") Long eventId){
               response = eventService.getForEntity(eventId);
        return ok(response);
    }

    @PostMapping
    public ResponseEntity postForEntity(@RequestBody Event event)
    {
        eventService.postForEntity(event);

        return status(201).build();
    }

}
