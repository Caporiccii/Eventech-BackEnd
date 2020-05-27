package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.UserService;
import com.bandtech.eventech.model.V1.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService = new UserService();
    User response;

    @GetMapping("/{userid}")
    public ResponseEntity getUsers(@PathVariable("userid") Long userId){

        response = userService.getForEntity(userId);

        return ok().body(response);
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody User user){

       userService.postForEntity(user);

        return status(201).build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity updateUser(@PathVariable int userId,
                                     @RequestBody User user) {


        return ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUserById(@PathVariable("userId")Long userId){

        userService.deleteForEntity(userId);

       return ok().build();
    }

}
