package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Repository.ICompanyRepository;
import com.bandtech.eventech.Repository.IUserRepository;
import com.bandtech.eventech.model.V2.CompanyJPA;
import com.bandtech.eventech.model.V2.UserJPA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;
import java.util.List;

@Service
public class LoginService  {
    @Autowired
    private IUserRepository repository;
    @Autowired
    private ICompanyRepository companyRepository;
    List<UserJPA> usuarios;
    List<CompanyJPA> empresas;
    String loginUser;
    String senhaUser;
    String loginCompany;
    String senhaCompany;
    private UserJPA user;
    private CompanyJPA company;
    private boolean result;
    private final Logger logger = LogManager.getLogger(LoginService.class);


    public Boolean logUsu(@PathParam("email") String email,
                           @PathParam("senha") String senha) {
try {
    findUserEmailAndPassword(email, senha);

    for (UserJPA user : usuarios) {
        loginUser = user.getEmail();
        senhaUser = user.getPassword();
        if (!email.equals(loginUser) && !senha.equals(senhaUser)) {
            logger.error("Login inválido");
            return result = false;
        } else {
            logger.info("Login Válido");
            return result = true;
        }
    }
    return result;
}
   catch (Exception exception){
    logger.error(exception + " Não foi possivel verificar seu login");
    return  result;
   }
  }

    public void findUserEmailAndPassword(String email, String senha){
        usuarios = repository.getNameandPassword(email,senha);
        user= new UserJPA();
        usuarios.add(user);
    }


    public Boolean logEmp(@PathParam("email") String email,
                          @PathParam("senha") String senha) {

        empresas = companyRepository.getCompanyandPassword(email,senha);
        company = new CompanyJPA();
        empresas.add(company);


        for (CompanyJPA company : empresas) {
            loginCompany = company.getEmail();
            senhaCompany = company.getPassword();
            if (!email.equals(loginCompany) && !senha.equals(senhaCompany)) {
                logger.error("Login inválido");
                return  result =false;
            } else {
                logger.info("Login Válido");
                return result=  true;
            }
        }
        return result;
}
}