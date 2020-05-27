package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.AddressJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdressRepository extends JpaRepository <AddressJPA,Integer> {
}
