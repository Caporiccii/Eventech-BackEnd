package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.PlaceJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaceRepository extends JpaRepository<PlaceJPA,Integer> {
}
