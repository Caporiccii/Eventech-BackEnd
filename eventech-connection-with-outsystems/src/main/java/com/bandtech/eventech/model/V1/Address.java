package com.bandtech.eventech.model.V1;

import com.sun.istack.NotNull;
import lombok.*;
import org.json.JSONObject;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
}
