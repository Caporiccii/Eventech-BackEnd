package com.bandtech.eventech.controller.V3;

import com.bandtech.eventech.Repository.V3.IUserTicketRepository;
import com.bandtech.eventech.model.V3.UserTicketJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v3/user/ticket")
public class UserTicketController {
    @Autowired
    private IUserTicketRepository repository;

    @PostMapping
    private ResponseEntity create(@RequestBody UserTicketJPA userTicket) {
        repository.save(userTicket);
        return status(201).build();
    }

    @GetMapping("/{userId}/status/{status}")
    private ResponseEntity getTicketByUser(
            @PathVariable("userId") Integer userId,
            @PathVariable("status") Integer status
    ) {
        List<UserTicketJPA> tickets = repository.getUserTicketByUserIdAndStatus(userId, status);

        if (tickets.isEmpty())
            return noContent().build();
        else
            return ok(tickets);
    }

    @DeleteMapping("/{userId}/status/{status}")
    private ResponseEntity deleteTicketByUser(
            @PathVariable("userId") Integer userId,
            @PathVariable("status") Integer status
    ){
        if (this.repository.existsById(userId) || this.repository.existsById(status)) {
            this.repository.deleteById(userId);
            return ok().build();
        }
        else{
            return notFound().build();

        }
    }
}
