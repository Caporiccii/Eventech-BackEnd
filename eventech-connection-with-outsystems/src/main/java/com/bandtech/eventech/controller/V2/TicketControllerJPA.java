package com.bandtech.eventech.controller.V2;

import com.bandtech.eventech.model.V2.TicketJPA;
import com.bandtech.eventech.Repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;


@RestController
@RequestMapping("/v2/tickets")
public class TicketControllerJPA {

    @Autowired
    private ITicketRepository repository;

    @PostMapping
    public ResponseEntity create(@RequestBody TicketJPA ticket){
        repository.save(ticket);

        return status(201).build();
    }
    @GetMapping
    public ResponseEntity get(){
        List <TicketJPA> ticket = repository.findAll();

        if (ticket == null)
        {
            return  noContent().build();
        }
        else{
            return ok(ticket);
        }
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity delete(@PathVariable int ticketId){
        if (this.repository.existsById(ticketId)) {
            this.repository.deleteById(ticketId);
            return ok().build();
        }
        else{
            return notFound().build();

        }
    }
    @PutMapping("/{ticketId}")
    public ResponseEntity update(@PathVariable int ticketId,
                                 @RequestBody TicketJPA ticket){
        Optional<TicketJPA> consultaExistente = this.repository.findById(ticketId);
        if(consultaExistente.isPresent()) {
            TicketJPA  ticketEncontrado = consultaExistente.get();

            ticketEncontrado.setName(ticket.getName());
            ticketEncontrado.setInitialDate((ticket.getInitialDate()));
            ticketEncontrado.setFinalDate(ticket.getFinalDate());
            ticketEncontrado.setEventId(ticket.getEventId());
            ticketEncontrado.setQtd(ticket.getQtd());
            ticketEncontrado.setQtdPerPerson(ticket.getQtdPerPerson());
            ticketEncontrado.setBuyer(ticket.getBuyer());
            ticketEncontrado.isPayment();
            ticketEncontrado.setPrice(ticket.getPrice());

            this.repository.save(ticketEncontrado);
            return ok().build();
        }
        else{
            return notFound().build();
        }
    }
}
