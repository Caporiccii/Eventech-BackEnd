package com.bandtech.eventech.controller.V2;
import com.bandtech.eventech.Service.V2.LoginService;
import com.bandtech.eventech.model.V2.CompanyJPA;
import com.bandtech.eventech.model.V2.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/login")
public class LoginControllerJPA {
    @Autowired
    private LoginService loginService;
    private UserJPA user;
    Boolean response = true;

   @GetMapping ("/{email}/{senha}")
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

    @GetMapping ("/empresa/{email}/{senha}")
    public ResponseEntity logEmpresa(@PathVariable("email") String email, @PathVariable("senha") String senha){

        response = loginService.logEmp(email,senha);

         if (!response)
        {
            return badRequest().build();
        }
        else {
            CompanyJPA companyJPA = new CompanyJPA();
            companyJPA.setActive(true);
            return ok().build();
        }
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity updateLog (@PathVariable("userId") Integer userId)
    {
        boolean isUpdated = loginService.updateLogUser(userId);

        if (isUpdated)
            return ok().build();
        else
            return badRequest().build();
    }

    @PutMapping("/company/{companyId}")
    public ResponseEntity updateLogCompany (@PathVariable("companyId") Integer companyId)
    {
        boolean isUpdated = loginService.updateLogCompany(companyId);

        if (isUpdated)
            return ok().build();
        else
            return badRequest().build();
    }
}
