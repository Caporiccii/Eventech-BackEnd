package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.EventJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventJPA extends JpaRepository<EventJPA,Integer> {
}
