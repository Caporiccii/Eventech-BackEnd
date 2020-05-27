package com.bandtech.eventech.Service.V1;

import com.bandtech.eventech.interfaces.IUserOut;
import com.bandtech.eventech.model.V1.EndPoints;
import com.bandtech.eventech.model.V1.User;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserService implements IUserOut {
    RestTemplate template = new RestTemplate();
    EndPoints endPoints = new EndPoints();
    JSONObject json = new JSONObject();
    User users;
    ResponseEntity<String> response;
    public User getForEntity(Long userId){

    response = template.getForEntity(endPoints.userEndpoint , String.class, userId);
    try {
        json = new JSONObject(response.getBody());
    }
    catch (Exception e){
        //logar a exception!!
        System.out.println(e);
    }
     users = new User(json);

    return users;
}

    public void postForEntity(User user) {
       response = template.postForEntity(
                endPoints.userPostEndpoint,user,String.class);
    }

    @Override
    public void deleteForEntity(Long userId) {
        template.delete( endPoints.userEndpoint,userId);
    }

    @Override
    public void putForEntity(Long userId, User user) {

    }
}
