package com.bandtech.eventech.Repository.V3;

import com.bandtech.eventech.model.V3.EventForMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEventForMobileRepository extends JpaRepository<EventForMobile,Integer> {

    @Query(value = "select a from EventForMobile a where a.createdBy = :userId")
    List<EventForMobile> getEventsByUser(@Param("userId") int userId);

   @Query("select count(link) from EventForMobile where id_event_mobile = idEventMobile")
    Integer getLinks(@Param("id_event_mobile") Integer idEventMobile);
}
