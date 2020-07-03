package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.EventJPA;
import com.bandtech.eventech.model.V2.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface IEventRepository extends JpaRepository<EventJPA,Integer> {
   // arrumar para trazer nome do evento
   @Query("select name from EventJPA where id = id")
   String getNameEvent();

   @Query("select count (id) from EventJPA")
   Integer getCountEvent();

   @Query("select id from EventJPA")
   Integer getIdEvent();

   @Query("select description from EventJPA where id = 1")
   String getDescriptionEvent();

   @Query("select isCancelled from EventJPA where id = 1")
   Boolean getIsCancelledEvent();

   @Query("SELECT ageRange from EventJPA where id = 1 ")
   String getAgeRangeEvent();

   @Query("SELECT initialDate from EventJPA where id = 1")
   String getInitialDate();

   @Query("SELECT finalDate from EventJPA where id = 1")
   String getFinalDate();
}
