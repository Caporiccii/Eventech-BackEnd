package com.bandtech.eventech.model.V1;

import lombok.*;
import org.json.JSONObject;

@Getter @Setter
@ToString
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String sex;
    private String birthday ;
    private String cpf ;
    private String phone ;
    private String creationDate;
    private int companyId;
    private boolean isActive;

    public User(JSONObject obj) {
        id = obj.getInt("Id");
        name = obj.getString("Name");
        surname = obj.getString("Surname");
        password = obj.getString("Password");
        email = obj.getString("Email");
        sex = obj.getString("Sex");
        birthday = obj.getString("Birthday");
        this.cpf = obj.getString("CPF");
        phone = obj.getString("Phone");
        creationDate = obj.getString("Creation_Date");
        companyId = obj.getInt("CompanyId");
        isActive = obj.getBoolean("Is_Active");
    }
}
