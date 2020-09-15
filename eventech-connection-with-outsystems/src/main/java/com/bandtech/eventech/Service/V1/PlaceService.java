package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.interfaces.IPlaceOut;
import com.bandtech.eventech.model.V1.EndPoints;
import com.bandtech.eventech.model.V1.Place;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PlaceService implements IPlaceOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json ;
    Place place;
    ResponseEntity<String> response;

    public Place getForEntity(Long placeId) {
        response = template.getForEntity(endPoints.placeEndpoint,
                String.class,placeId);
        try {
            json = new JSONObject(response.getBody());
        }
        catch (Exception e){
            //logar a exception!!
            System.out.println(e);
        }
        place = new Place(json);
        return place;
    }

    @Override
    public void postForEntity(Place place) {

        template.postForEntity(endPoints.placePostEndpoint,place,String.class);
    }

    @Override
    public void deleteForEntity(Long placeId) {
         template.delete(endPoints.placeEndpoint,placeId);
    }

    @Override
    public void putForEntity(Long placeId, Place company) {

    }
}
