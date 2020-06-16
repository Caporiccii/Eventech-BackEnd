package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Event;

import java.util.List;

public interface IEventOut {

    Event getForEntity(Long eventId);

    Event getForEntityV2(Long eventId);

    List getEventList();

    void postForEntity(Event event);

    void deleteForEntity(Long eventId);

    void putForEntity(Long eventId,Event event);

}
