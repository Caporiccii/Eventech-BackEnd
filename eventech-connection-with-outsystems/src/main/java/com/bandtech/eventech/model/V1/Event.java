package com.bandtech.eventech.model.V1;


import org.json.JSONObject;


public class Event {

    public int id;
    public String name;
    public String initialDate;
    public String finalDate;
    public int placeId;
    public int createdBy;
    public String description;
    public String ageRange;

    public Event() {
    }

    public Event(JSONObject obj) {
        this.id = obj.getInt("Id");
        name = obj.getString("Name");
        initialDate = obj.getString("InitialDate");
        finalDate = obj.getString("FinalDate");
        placeId = obj.getInt("PlaceId") ;
        createdBy = obj.getInt("CreatedBy") ;
        description = obj.getString("Description");
         }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
}
