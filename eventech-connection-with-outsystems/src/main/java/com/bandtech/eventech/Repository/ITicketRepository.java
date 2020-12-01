package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.TicketJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITicketRepository extends JpaRepository<TicketJPA,Integer> {
    @Query("SELECT price FROM TicketJPA where id = 1")
    Double getPrice();

    @Query("select count (id) from TicketJPA")
    Integer getCountTicket();

    @Query("SELECT SUM(price) from TicketJPA")
    Double getTotalSaleTicket();

    @Query("select a from TicketJPA a where a.eventId = :eventId")
    List<TicketJPA> getTicketsByEventId(Integer eventId);
}
