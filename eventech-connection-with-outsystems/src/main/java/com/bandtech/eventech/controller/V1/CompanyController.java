package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.CompanyService;
import com.bandtech.eventech.model.V1.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/companys")
public class CompanyController {

    CompanyService companyService = new CompanyService();
    Company response;

    @GetMapping("/{companyId}")
    public ResponseEntity getForEntity(@PathVariable("companyId") Long companyId){

        response = companyService.getForEntity(companyId);

        return ok().body(response);
    }

    @PostMapping
    public ResponseEntity postForEntity(@RequestBody Company company){

        companyService.postForEntity(company);

        return status(201).build();
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity updateUser(@PathVariable ("companyId")Long companyId){

         companyService.deleteForEntity(companyId);

        return ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity putForEntity(@PathVariable ("companyId")Long companyId,
                                     @RequestBody Company company) {


        return ok().build();
    }
}
