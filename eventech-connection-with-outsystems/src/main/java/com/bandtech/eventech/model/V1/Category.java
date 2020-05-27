package com.bandtech.eventech.model.V1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter @Setter
@ToString
@AllArgsConstructor
public class Category {

    private int id;
    private String Name;
    private String Description;

    public Category(JSONObject obj){
        id = obj.getInt("Id");
        Name = obj.getString("Name");
        Description = obj.getString("Description");
    }
}
