package com.bandtech.eventech.model.V1;

import lombok.*;
import org.json.JSONObject;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventMail {

  //  public int id;
    public String name;
    public String initialDate;
    public String finalDate;
    public String category;
    public Double price;
    public String address;


    public EventMail(JSONObject obj) {
    //    this.id = obj.getInt("Id");
        name = obj.getString("Name");
        initialDate = obj.getString("InitialDate");
        finalDate = obj.getString("FinalDate");
        category = obj.getString("Category") ;
        price = obj.getDouble("Price") ;
        address = obj.getString("Address");
        }

}
