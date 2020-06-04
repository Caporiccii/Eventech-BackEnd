package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Event;

public interface IEventOut {

    Event getForEntity(Long eventId);

    void postForEntity(Event event);

    void deleteForEntity(Long eventId);

    void putForEntity(Long eventId,Event event);

}
