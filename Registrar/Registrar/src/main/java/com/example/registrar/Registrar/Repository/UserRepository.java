package com.example.registrar.Registrar.Repository;

import com.example.registrar.Registrar.Dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Configuration
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

