package com.bandtech.eventech.model.V1;


import org.json.JSONObject;



public class Address {
    private int id;
    private String city;
    private String state;
    private String zipCode;
    private String street;
    private int streetNumber;

    public Address(JSONObject obj){
        id = obj.getInt("Id");
        city = obj.getString("City");
        state = obj.getString("State");
        zipCode = obj.getString("ZipCode");
        street = obj.getString("Street");
        streetNumber = obj.getInt("StreetNumber");
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
