package com.bandtech.eventech.model.V1;

import lombok.*;
import org.json.JSONObject;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private int id;
    private String Name;
    private int AddressId;
    private String Description;
    private int Capacity;

    public Place (JSONObject obj)
    {
        id = obj.getInt("Id");
        Name = obj.getString("Name");
        AddressId = obj.getInt("AddressId");
        Description = obj.getString("Description");
        Capacity = obj.getInt("Capacity");
    }

}
