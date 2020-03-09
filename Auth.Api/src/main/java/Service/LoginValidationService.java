package Service;


import DTO.logUser;
import Interface.IValidationLog;

import java.util.ArrayList;

public class LoginValidationService implements IValidationLog {
    public String nome;
    public String senha;
    logUser log = new logUser(nome,senha);
    ArrayList<logUser> logUsers = new ArrayList<>();
    public boolean isValid = true;

    public boolean validaLogin(){

        if(log.senhaLog != log.getSenhaLog() && log.nomeLog != log.getNomeLog()){
            return isValid = false;
        }
        else {
            return isValid;
        }
    }
}
