package Controller;

import DTO.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    Cliente cliente = new Cliente();

    @GetMapping ("/teste")
    public double teste (){
double a = cliente.getIdade();
        return a;
    }
}
