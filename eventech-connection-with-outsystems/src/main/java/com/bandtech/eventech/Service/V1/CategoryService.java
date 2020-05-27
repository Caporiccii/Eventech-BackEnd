package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.interfaces.ICategoryOut;
import com.bandtech.eventech.model.V1.Category;
import com.bandtech.eventech.model.V1.EndPoints;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CategoryService implements ICategoryOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json = new JSONObject();
    Category category;
    ResponseEntity<String> response;

    @Override
    public Category getForEntity(Long categoryId) {
        response = template.getForEntity(endPoints.categoryEndpoint , String.class, categoryId);
        try {
            json = new JSONObject(response.getBody());
        }
        catch (Exception e){
            //logar a exception!!
            System.out.println(e);
        }
        category = new Category(json);
     return category;
    }


    public void postForEntity(Category category) {
        response = template.postForEntity(
                endPoints.categoryPostEndpoint,category,String.class);
    }

    @Override
    public void deleteForEntity(Long categoryId) {
        template.delete(endPoints.categoryEndpoint ,categoryId);
    }

    @Override
    public void putForEntity(Long categoryId, Category category) {

    }
}
