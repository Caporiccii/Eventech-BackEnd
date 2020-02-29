package Controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class logController {
    public boolean isValid = true;
    @GetMapping("/login/")
    public String getLogin (@PathVariable("nomeUser") String nomeUser ,@PathVariable("senhaUser") String senhaUser)
    {
                 if (nomeUser == "Marco" && senhaUser == "123")
                 {
                     return "logado com sucesso";
                 }
                 else {
        return "Não encontrado";
                 }

    }
    @PostMapping("/login/{nomeUSer/senhaUser}")
    public String addLogin (@PathVariable("nomeUser") String nomeUser ,@PathVariable("senhaUser") String senhaUser)
    {
        if (nomeUser == "Marco" && senhaUser == "123")
        {
            return "logado com sucesso";
        }
        else {
            return "Não encontrado";
        }



    }
