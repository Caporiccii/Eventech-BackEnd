package com.bandtech.eventech.Service.V1;
import com.bandtech.eventech.crosscutting.PilhaObj;
import com.bandtech.eventech.interfaces.IHistory;
import com.bandtech.eventech.model.V1.EndPoints;
import com.bandtech.eventech.model.V1.HistoryOut;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class HistoryServiceOut implements IHistory {
    private RestTemplate template = new RestTemplate();
    private PilhaObj<HistoryOut> historyStack;
    private List<HistoryOut> historyList = new ArrayList<>();
    private ResponseEntity<String> response;
    private  HistoryOut history;
    private EndPoints endPoints;
    private JSONObject json = new JSONObject();

      public HistoryOut getForEntity(Long EventId){

          endPoints = new EndPoints();
          response = template.getForEntity(endPoints.eventEndpointV3, String.class, EventId);

          try {
              json = new JSONObject(response.getBody());
          }
          catch (Exception e){
              //logar a exception!!
              System.out.println(e);
          }

          history = new HistoryOut(json);

          return history;
      }

      public HistoryOut createHistory(Long EventId){
         try {
           historyStack = new PilhaObj<>(1000);
             history = getForEntity(EventId);

             historyStack.push(history);
         }
         catch (Exception ex){
             System.out.println(ex);
         }
          return history;
      }

}
