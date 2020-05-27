package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.CategoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryJPA,Integer> {


}
