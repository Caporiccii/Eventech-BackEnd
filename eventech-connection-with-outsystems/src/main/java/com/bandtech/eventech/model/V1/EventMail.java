package com.bandtech.eventech.model.V1;


import org.json.JSONObject;


public class EventMail {

  //  public int id;
    public String name;
    public String initialDate;
    public String finalDate;
    public String category;
    public Double price;
    public String address;

    public EventMail() {
    }

    public EventMail(JSONObject obj) {
    //    this.id = obj.getInt("Id");
        name = obj.getString("Name");
        initialDate = obj.getString("InitialDate");
        finalDate = obj.getString("FinalDate");
        category = obj.getString("Category") ;
        price = obj.getDouble("Price") ;
        address = obj.getString("Address");
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
