package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.TicketJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketRepository extends JpaRepository<TicketJPA,Integer> {
    @Query("SELECT price FROM TicketJPA where id = 1")
    Double getPrice();

    @Query("select count (id) from TicketJPA")
    Integer getCountTicket();

    @Query("SELECT SUM(price) from TicketJPA")
    Double getTotalSaleTicket();

    @Query(value = "select a from TicketJPA a where a.fk_event in :fk_event")
    List<TicketJPA> getTicketsByEventId(@Param("fk_event") Integer fk_event);
}
