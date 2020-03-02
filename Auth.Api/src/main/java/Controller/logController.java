package Controller;


import DTO.logUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/auth")
@RestController
public class logController {
    public boolean isValid = true;
    logUser log;
    ArrayList<logUser> logLista = new ArrayList<>();

    @GetMapping("/users")
    public ArrayList<logUser> getLogin() {
        return logLista;
    }

    // endpoint apenas para teste, ele sera movido para a api de crud
    @PostMapping("/log/{nome}/{senha}")
    public void addLogin(@PathVariable("nome") String nome,
                         @PathVariable("senha") String senha) {
        log = new logUser(nome, senha);
        logLista.add(log);
    }

    @GetMapping("/log")
    public boolean logUser() {
 //if (log.nomeLog.contains(logLista.toString() && log.senhaLog.contains(logLista.toString())))

        return isValid;
    }
}
