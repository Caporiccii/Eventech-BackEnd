package com.bandtech.eventech.model.V1;

import lombok.*;
import org.json.JSONObject;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    public int id;
    public String name;
    public String initialDate;
    public String finalDate;
    public int categoryId;
    public int placeId;
    public int createdBy;
    public String description;
    public boolean isCancelled;
    public String ageRange;

    public Event(JSONObject obj) {
        this.id = obj.getInt("Id");
        name = obj.getString("Name");
        initialDate = obj.getString("InitialDate");
        finalDate = obj.getString("FinalDate");
        categoryId = obj.getInt("CategoryId");
        placeId = obj.getInt("PlaceId") ;
        createdBy = obj.getInt("CreatedBy") ;
        description = obj.getString("Description");
        isCancelled = obj.has("IsCancelled");
        ageRange = obj.getString("AgeRange");
    }
}
