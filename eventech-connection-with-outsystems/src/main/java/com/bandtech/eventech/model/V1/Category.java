package com.bandtech.eventech.model.V1;


import org.json.JSONObject;

public class Category {

    private int id;
    private String Name;
    private String Description;

    public Category() {
    }

    public Category(JSONObject obj){
        id = obj.getInt("Id");
        Name = obj.getString("Name");
        Description = obj.getString("Description");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
