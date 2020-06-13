package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.TicketJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITicketRepository extends JpaRepository<TicketJPA,Integer> {
    @Query("SELECT price FROM TicketJPA")
    Double getPrice();
}
