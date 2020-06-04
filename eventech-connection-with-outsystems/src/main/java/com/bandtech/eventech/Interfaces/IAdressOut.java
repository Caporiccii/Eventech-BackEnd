package com.bandtech.eventech.Interfaces;

import com.bandtech.eventech.model.V1.Address;
import com.bandtech.eventech.model.V1.Category;

public interface IAdressOut {
    Address getForEntity(Long addressId);

    void postForEntity(Address address);

    void deleteForEntity(Long addressId);

    void putForEntity(Long addressId, Address address);
}
