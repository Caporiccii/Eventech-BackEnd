package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.interfaces.ICompanyOut;
import com.bandtech.eventech.model.V1.Company;
import com.bandtech.eventech.model.V1.EndPoints;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CompanyService implements ICompanyOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json ;
   Company company;
    ResponseEntity<String> response;
    @Override
    public Company getForEntity(Long companyId) {

        response = template.getForEntity(endPoints.companyEndpoint , String.class, companyId);
        try {
            json = new JSONObject(response.getBody());
        }
        catch (Exception e){
            //logar a exception!!
            System.out.println(e);
        }
        company = new Company(json);

        return company;
    }

    @Override
    public void postForEntity(Company company) {
          response = template.postForEntity(
                 endPoints.companyPostEndpoint,company,String.class);
    }

    @Override
    public void deleteForEntity(Long companyId) {
                 template.delete(endPoints.companyEndpoint,companyId);
    }

    @Override
    public void putForEntity(Long companyId, Company company) {

    }
}
