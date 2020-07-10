package com.bandtech.eventech.model.V2;


import javax.persistence.*;

@Entity
public class PlaceJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private int AddressId;
    private String Description;
    private int Capacity;

    public PlaceJPA() {
    }

    public PlaceJPA(int id, String name, int addressId, String description, int capacity) {
        this.id = id;
        Name = name;
        AddressId = addressId;
        Description = description;
        Capacity = capacity;
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
