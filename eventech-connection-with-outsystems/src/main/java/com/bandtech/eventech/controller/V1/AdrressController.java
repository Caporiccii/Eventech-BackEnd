package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.AddressService;
import com.bandtech.eventech.model.V1.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;
@Api(value = "Endereço evento")
@RestController
@RequestMapping("/address")
public class AdrressController {

    AddressService addressService = new AddressService();
    Address response;

    @ApiOperation(value = "Retorna endereço")
    @GetMapping("/{addressId}")
    public ResponseEntity getForEntity(@PathVariable("addressId")Long addressId)
    {
          response = addressService.getForEntity(addressId);

        return ok().body(response);
    }

    @PostMapping
    public ResponseEntity postForEntity(@RequestBody Address address)
    {
     //   addressService.postForEntity(address);
addressService.postForEntity(address);
        return status(201).build();
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity deleteUser(@PathVariable("addressId")Long addressId){

        addressService.deleteForEntity(addressId);

        return ok().build();
    }

    @PutMapping("/{addressId}")
    public ResponseEntity putForEntity(@PathVariable("addressId")Long addressId,
                                       @RequestBody Address address) {

        addressService.putForEntity(addressId,address);

        return ok().build();
    }
}
