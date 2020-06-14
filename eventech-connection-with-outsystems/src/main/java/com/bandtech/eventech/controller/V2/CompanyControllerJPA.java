package com.bandtech.eventech.controller.V2;

import com.bandtech.eventech.Service.V2.DateFormatService;
import com.bandtech.eventech.model.V2.CompanyJPA;
import com.bandtech.eventech.Repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/companys/CompanyJPA")
public class CompanyControllerJPA {
    @Autowired
    private ICompanyRepository repository;
    private DateFormatService formatService;

    @PostMapping
    public ResponseEntity create(@RequestBody CompanyJPA company){
        String formattedDate;
        formatService = new DateFormatService();
        formattedDate = formatService.formatDate();
        company.setCreationDate(formattedDate);
        repository.save(company);
        return status(201).build();
    }
    @GetMapping("/{companyId}")
    public ResponseEntity get(@PathVariable int companyId){
        Optional<CompanyJPA> company = repository.findById(companyId);


            if (!company.isPresent())
            {
                return  badRequest().build();
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
