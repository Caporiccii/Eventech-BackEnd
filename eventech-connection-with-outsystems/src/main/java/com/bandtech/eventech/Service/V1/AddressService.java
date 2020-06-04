package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.Interfaces.IAdressOut;
import com.bandtech.eventech.model.V1.Address;
import com.bandtech.eventech.model.V1.EndPoints;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AddressService implements IAdressOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json ;
    Address address;
    ResponseEntity<String> response;

    @Override
    public Address getForEntity(Long addressId) {

       response = template.getForEntity(endPoints.addressEndpoint,
               String.class,addressId);
        try {
            json = new JSONObject(response.getBody());
        }
        catch (Exception e){
            //logar a exception!!
            System.out.println(e);
        }
        Address address = new Address(json);
        return address;
    }

    @Override
    public void postForEntity(Address address) {
         template.postForEntity(endPoints.addressPostEndpoint,address,String.class);
    }

    @Override
    public void deleteForEntity(Long addressId) {
                 template.delete(endPoints.addressEndpoint,addressId);
    }

    @Override
    public void putForEntity(Long addressId, Address address) {

    }
}
