package Controller;


import DTO.logUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/auth")
@RestController
public class logController {
    public boolean IsValid = true;
    logUser log;
    ArrayList<logUser> logLista = new ArrayList<>();

    @GetMapping("/users")
    public logUser getLogin() {
        return log;
    }

    // endpoint apenas para teste, ele sera movido para a api de crud
    @PostMapping("/log/{nome}/{senha}")
    public boolean addLogin(@PathVariable("nome") String nome,
                         @PathVariable("senha") String senha) {
        if (nome.equals("Marco") && senha.equals("123"))
        {
            log = new logUser(nome,senha);
            logLista.add(log);
            return IsValid = true;
        }
        else{
            IsValid = false;
        }
        return  IsValid;
    }

    }
