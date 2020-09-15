package com.bandtech.eventech.controller.V1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/log")
public class LoginController {

    @GetMapping ("/{nome}/{senha}")
    public ResponseEntity logUser(@PathVariable String nome, @PathVariable String senha){

        if (!(nome.equals("adm") && senha.equals("123")))
        {
            System.out.println("Login inválido");
            return badRequest().build();
        }
        else{
            System.out.println("Login Válido");
            return ok().build();
        }
    }

    @GetMapping ("/empresa/{empresa}/{senha}")
    public ResponseEntity logEmpresa(@PathVariable String empresa, @PathVariable String senha){

        if (!(empresa.equals("adm") && senha.equals("123")))
        {
            System.out.println("Login inválido");
            return badRequest().build();
        }
        else{
            System.out.println("Login Válido");
            return ok().build();
        }
    }

}
