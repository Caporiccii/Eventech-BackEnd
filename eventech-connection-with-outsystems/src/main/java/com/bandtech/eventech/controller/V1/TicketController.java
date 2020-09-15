package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.TicketService;
import com.bandtech.eventech.model.V1.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    TicketService ticketService = new TicketService();
    Ticket response;

    @GetMapping("/{eventId}")
    public ResponseEntity getForEntity(@PathVariable("eventId")Long eventId)
    {
        response = ticketService.getForEntity(eventId);

        return ok().body(response);
    }
    @PostMapping
    public ResponseEntity postForEntity(@RequestBody Ticket ticket)
    {
        ticketService.postForEntity(ticket);

        return status(201).build();
    }
}
