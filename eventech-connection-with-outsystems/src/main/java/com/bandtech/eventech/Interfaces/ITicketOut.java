package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Ticket;

public interface ITicketOut {

    Ticket getForEntity(Long ticketId);

    void postForEntity(Ticket ticket);

    void deleteForEntity(Long ticketId);

    void putForEntity(Long ticketId,Ticket ticket);

}
