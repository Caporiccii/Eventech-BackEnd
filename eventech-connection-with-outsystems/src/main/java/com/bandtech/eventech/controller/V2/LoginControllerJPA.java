package com.bandtech.eventech.controller.V2;
import com.bandtech.eventech.Service.V2.LoginService;
import com.bandtech.eventech.model.V2.CompanyJPA;
import com.bandtech.eventech.model.V2.UserJPA;
import com.bandtech.eventech.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/v2/login")
public class LoginControllerJPA {
    @Autowired
    private LoginService loginService;
    private UserJPA user;
    Boolean response = true;

   @GetMapping ("/{nome}/{senha}")
    public ResponseEntity logUser(@PathVariable("email") String email,
                                  @PathVariable("senha") String senha)
   {
       response = loginService.logUsu(email,senha);

       if (!response)
       {
           return badRequest().build();
       }
       else {
           return ok().build();
       }
   }

    @GetMapping ("/empresa/{nome}/{senha}")
    public ResponseEntity logEmpresa(@PathVariable("email") String email, @PathVariable("senha") String senha){

        response = loginService.logEmp(email,senha);

         if (!response)
        {
            return badRequest().build();
        }
        else {
            return ok().build();
        }
    }

    @PostMapping("/empresa/{isActive}/CompanyJPA")
    public ResponseEntity logouEmpresa(@RequestBody CompanyJPA companyJPA){
       companyJPA.setActive(false);
       return status(201).build();
    }

    @PostMapping("/user/{isActive}/UserJPA")
    public ResponseEntity logouUser(@RequestBody UserJPA user){
      user.setActive(false);
      return status(201).build();
    }
}
