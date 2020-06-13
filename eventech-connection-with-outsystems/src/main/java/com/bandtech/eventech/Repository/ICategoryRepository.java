package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.CategoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICategoryRepository extends JpaRepository<CategoryJPA,Integer> {
   @Query("SELECT Name FROM CategoryJPA where id = 1")
    String getCategoryEvent();

}
