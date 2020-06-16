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
}
