package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.PlaceService;
import com.bandtech.eventech.model.V1.Place;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/places")
public class PlaceController {

    PlaceService placeService = new PlaceService();
    Place response;

    @GetMapping("/{placeId}")
    public ResponseEntity getForEntity(@PathVariable("placeId")Long placeId)
    {
        response = placeService.getForEntity(placeId);

        return ok().body(response);
    }

    @PostMapping
    public ResponseEntity postForEntity(@RequestBody Place place)
    {
        placeService.postForEntity(place);

        return status(201).build();
    }

    @DeleteMapping("/{placeId}")
    public ResponseEntity updateUser(@PathVariable("placeId")Long placeId){

        placeService.deleteForEntity(placeId);

        return ok().build();
    }

    @PutMapping("/{placeId}")
    public ResponseEntity putForEntity(@PathVariable("placeId")Long placeId,
                                       @RequestBody Place place) {


        return ok().build();
    }
}
