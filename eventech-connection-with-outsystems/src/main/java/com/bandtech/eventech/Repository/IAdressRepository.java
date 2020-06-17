package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.AddressJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAdressRepository extends JpaRepository <AddressJPA,Integer> {
    @Query("SELECT street FROM AddressJPA where id = 1")
    String getStreet();

    @Query("SELECT streetNumber FROM AddressJPA where id = 1")
    Integer getStreetNumber();

}
