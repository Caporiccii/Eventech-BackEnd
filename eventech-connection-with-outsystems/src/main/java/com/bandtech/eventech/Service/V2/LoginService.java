package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Repository.ICompanyRepository;
import com.bandtech.eventech.Repository.IUserRepository;
import com.bandtech.eventech.model.V2.CompanyJPA;
import com.bandtech.eventech.model.V2.UserJPA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

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
    private boolean isUpdated;
    private Integer id_User;
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
            user.setActive(true);
            user.isActive();
            this.repository.save(user);
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

    public Integer returnId(String email, String senha){
        id_User = repository.getIdNameandPassword(email,senha);

        return id_User;
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
                company.setActive(true);

                company.isActive();
                this.companyRepository.save(company);

                logger.info("Login Válido");
                return result=  true;
            }
        }
        return result;
}
    public boolean updateLogUser (@PathVariable("userId") Integer userId){

        Optional<UserJPA> userLogged = repository.findById(userId);

        if (userLogged.isPresent()){
         user = userLogged.get();

            user.setActive(false);
            user.isActive();

          this.repository.save(user);
            return isUpdated = true;
        }
        else{
            return isUpdated = false;
    }}

    public boolean updateLogCompany (@PathVariable("companyId") Integer companyId){

        Optional<CompanyJPA> companyLogged = companyRepository.findById(companyId);

        if (companyLogged.isPresent()){
            company = companyLogged.get();

            company.setActive(false);
            company.isActive();

            this.companyRepository.save(company);
            return isUpdated = true;
        }
        else{
            return isUpdated = false;
        }}
}