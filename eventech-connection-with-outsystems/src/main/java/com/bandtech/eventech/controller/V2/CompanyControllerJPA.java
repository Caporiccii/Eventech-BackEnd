package com.bandtech.eventech.controller.V2;

import com.bandtech.eventech.model.V2.CompanyJPA;
import com.bandtech.eventech.Repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/companys")
public class CompanyControllerJPA {

    @Autowired
    private ICompanyRepository repository;

    @PostMapping
    public ResponseEntity create(@RequestBody CompanyJPA company){
        repository.save(company);

        return status(201).build();
    }
    @GetMapping
    public ResponseEntity get(){
        List<CompanyJPA> company = repository.findAll();

        if (company == null)
        {
            return  noContent().build();
        }
        else{
            return ok(company);
        }
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity delete(@PathVariable int companyId){
        if (this.repository.existsById(companyId)) {
            this.repository.deleteById(companyId);
            return ok().build();
        }
        else{
            return notFound().build();

        }
    }
    @PutMapping("/{companyId}")
    public ResponseEntity update(@PathVariable int companyId,
                                 @RequestBody CompanyJPA company){
        Optional<CompanyJPA> consultaExistente = this.repository.findById(companyId);
        if(consultaExistente.isPresent()) {
            CompanyJPA companyEncontrado = consultaExistente.get();

            companyEncontrado.setName(company.getName());
            companyEncontrado.setEmail(company.getName());
            companyEncontrado.setAbout(company.getAbout());
            companyEncontrado.setCnpj(company.getCnpj());
            companyEncontrado.setPhone(company.getPhone());
            companyEncontrado.isActive();
            companyEncontrado.setSocialReason(company.getSocialReason());
            companyEncontrado.setFantasyName(company.getFantasyName());

            this.repository.save(companyEncontrado);
            return ok().build();
        }
        else{
            return notFound().build();
        }
    }
}