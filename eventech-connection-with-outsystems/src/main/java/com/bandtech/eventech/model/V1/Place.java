package com.bandtech.eventech.model.V1;


import org.json.JSONObject;


public class Place {

    private int id;
    private String Name;
    private int AddressId;
    private String Description;
    private int Capacity;


    public Place() { }

    public Place (JSONObject obj)
    {
        id = obj.getInt("Id");
        Name = obj.getString("Name");
        AddressId = obj.getInt("AddressId");
        Description = obj.getString("Description");
        Capacity = obj.getInt("Capacity");
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

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}
