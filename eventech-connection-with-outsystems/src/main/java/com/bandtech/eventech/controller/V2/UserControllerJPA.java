package com.bandtech.eventech.controller.V2;


import com.bandtech.eventech.model.V2.UserJPA;
import com.bandtech.eventech.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/users")
public class UserControllerJPA {
    @Autowired
    private IUserRepository repository;

    @PostMapping("/UserJPA")
    public ResponseEntity create(@RequestBody UserJPA user) {
        repository.save(user);

        return status(201).build();
    }

    @GetMapping("/UserJPA")
    public ResponseEntity get() {
        List<UserJPA> user = repository.findAll();

        if (user == null) {
            return noContent().build();
        } else {
            return ok(user);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity delete(@PathVariable int userId) {
        if (this.repository.existsById(userId)) {
            this.repository.deleteById(userId);
            return ok().build();
        } else {
            return notFound().build();

        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity update(@PathVariable int userId,
                                 @RequestBody UserJPA user) {
        Optional<UserJPA> consultaExistente = this.repository.findById(userId);
        if (consultaExistente.isPresent()) {
            UserJPA userEncontrado = consultaExistente.get();

            userEncontrado.setName(user.getName());
            userEncontrado.setSurname(user.getSurname());
            userEncontrado.setEmail(user.getEmail());
            userEncontrado.setSex(user.getSex());
            userEncontrado.setPhone(user.getPhone());
            userEncontrado.setCompanyId(user.getCompanyId());
            userEncontrado.isActive();

            this.repository.save(userEncontrado);
            return ok().build();
        } else {
            return notFound().build();
        }
    }
}
