package com.bandtech.eventech.controller.V2;


import com.bandtech.eventech.model.V2.AddressJPA;
import com.bandtech.eventech.Repository.IAdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/address/AddressJPA")
public class AddressControllerJPA {
      @Autowired
    IAdressRepository repository;

    @PostMapping
    public ResponseEntity create(@RequestBody AddressJPA address){
        repository.save(address);

        return status(201).build();
    }

        @GetMapping("/{addressId}")
        public ResponseEntity get(@PathVariable int addressId ) {
            Optional<AddressJPA> address = repository.findById(addressId);


            if (!address.isPresent()) {
                return badRequest().build();
            } else {
                return ok(address);
            }

        }
    @DeleteMapping("/{addressId}")
    public ResponseEntity delete(@PathVariable int addressId){
        if (this.repository.existsById(addressId)) {
            this.repository.deleteById(addressId);
            return ok().build();
        }
        else{
            return notFound().build();

        }
    }

    @PutMapping("/{addressId}")
    public ResponseEntity update(@PathVariable int addressId,
                                 @RequestBody AddressJPA address){
        Optional<AddressJPA> consultaExistente = this.repository.findById(addressId);
        if(consultaExistente.isPresent()) {
            AddressJPA addressEncontrado = consultaExistente.get();

            addressEncontrado.setCity(address.getCity());
            addressEncontrado.setState(address.getState());
            addressEncontrado.setZipCode(address.getZipCode());
            addressEncontrado.setStreet(address.getStreet());
            addressEncontrado.setStreetNumber(address.getStreetNumber());

            this.repository.save(addressEncontrado);
            return ok().build();
        }
        else{
            return notFound().build();
        }
    }

}
