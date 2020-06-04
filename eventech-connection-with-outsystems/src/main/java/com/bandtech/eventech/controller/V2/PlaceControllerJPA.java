package com.bandtech.eventech.controller.V2;


import com.bandtech.eventech.model.V2.PlaceJPA;
import com.bandtech.eventech.Repository.IPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/places/PlaceJP")
public class PlaceControllerJPA {

    @Autowired
    private IPlaceRepository repository;
    @PostMapping
    public ResponseEntity create(@RequestBody PlaceJPA place){
        repository.save(place);

        return status(201).build();
    }
    @GetMapping("/{placeId}")
    public ResponseEntity get(@PathVariable int placeId){
        Optional<PlaceJPA> place = repository.findById(placeId);


            if (!place.isPresent())
            {

                return  badRequest().build();
            }
            else{
                return ok(place);
        }
    }

    @DeleteMapping("/{placeId}")
    public ResponseEntity delete(@PathVariable int placeId){
        if (this.repository.existsById(placeId)) {
            this.repository.deleteById(placeId);
            return ok().build();
        }
        else{
            return notFound().build();

        }
    }
    @PutMapping("/{placeId}")
    public ResponseEntity update(@PathVariable int placeId,
                                 @RequestBody PlaceJPA place){
        Optional<PlaceJPA> placeExistente = this.repository.findById(placeId);
        if(placeExistente.isPresent()) {
            PlaceJPA placeEncontrado = placeExistente.get();

            placeEncontrado.setName(place.getName());
            placeEncontrado.setAddressId(place.getAddressId());
            placeEncontrado.setDescription(place.getDescription());
            placeEncontrado.setCapacity(place.getCapacity());

            this.repository.save(placeEncontrado);
            return ok().build();
        }
        else{
            return notFound().build();
        }
    }
}
