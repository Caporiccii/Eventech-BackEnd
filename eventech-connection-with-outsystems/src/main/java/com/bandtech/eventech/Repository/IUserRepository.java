package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V2.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserJPA,Integer> {

    @Query("select a from UserJPA a where a.name in :nome and a.password in :senha")
    List<UserJPA> getNameandPassword(@Param("nome") String nome,
                                     @Param("senha") String senha);
}
