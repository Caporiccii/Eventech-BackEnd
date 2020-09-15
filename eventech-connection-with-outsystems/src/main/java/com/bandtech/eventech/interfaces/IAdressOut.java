package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Address;

public interface IAdressOut {
    Address getForEntity(Long addressId);

    void postForEntity(Address address);

    Long deleteForEntity(Long addressId);

    void putForEntity(Long addressId, Address address);
}
