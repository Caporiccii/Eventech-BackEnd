package com.bandtech.eventech.Repository;

import com.bandtech.eventech.model.V1.Company;
import com.bandtech.eventech.model.V2.CompanyJPA;
import com.bandtech.eventech.model.V2.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompanyRepository extends JpaRepository<CompanyJPA,Integer> {
    @Query("select a from CompanyJPA a where a.name in :nome and a.password in :senha")
    List<CompanyJPA> getCompanyandPassword(@Param("nome") String nome,
                                            @Param("senha") String senha);
    @Query("SELECT name FROM CompanyJPA")
    String getNameCompany();

}
