package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.EventJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface IEventJPA extends JpaRepository<EventJPA,Integer> {
   // Object findByQuery(String s, Map<String, Object> map);
}
