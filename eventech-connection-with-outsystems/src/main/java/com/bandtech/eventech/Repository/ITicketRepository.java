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

    @Query(value = "select a from TicketJPA a where a.event_Id in :event_Id")
    List<TicketJPA> getTicketsByEventId(@Param("event_Id") Integer event_Id);

    @Query("select sum(price) from TicketJPA where event_id = event_id")
    Double getAllPriceByEventid(@Param("event_Id") Integer event_Id);

    @Query("select count(id_ticket)from TicketJPA where event_id = event_id")
    Integer getAllTicketByEventid(@Param("event_Id") Integer event_Id);


}
