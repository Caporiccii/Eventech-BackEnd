package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Place;

public interface IPlaceOut {

    Place getForEntity(Long placeId);

    void postForEntity(Place place);

    void deleteForEntity(Long placeId);

    void putForEntity(Long placeId,Place place);
}
