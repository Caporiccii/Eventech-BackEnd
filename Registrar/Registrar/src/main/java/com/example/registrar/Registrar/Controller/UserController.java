package com.example.registrar.Registrar.Controller;

import com.example.registrar.Registrar.Dto.User;

import com.example.registrar.Registrar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class UserController {

    private UserRepository repository;


    @GetMapping("/lista")
    public List findAll() {
        return repository.findAll();
    }

    @PostMapping("/cadastro")
    public User create(@RequestBody User user) {
        return repository.save(user);
    }
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable int id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
