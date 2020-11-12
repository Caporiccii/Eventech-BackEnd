package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserJPA,Integer> {

    @Query("select a from UserJPA a where a.email in :email and a.password in :senha")
    List<UserJPA> getNameandPassword(@Param("email") String email,
                                     @Param("senha") String senha);
}
