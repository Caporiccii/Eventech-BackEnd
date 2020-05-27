package com.bandtech.eventech.model.V1;

import lombok.*;
import org.json.JSONObject;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private int id;
    private String name;
    private String password;
    private String email;
    private String about;
    private String cnpj;
    private String phone;
    private String creationDate;
    private boolean isActive;
    private String socialReason;
    private String fantasyName;

    public Company(JSONObject obj) {
        id = obj.getInt("Id");

        name = obj.getString("Name");
        password = obj.getString("Password");
        email = obj.getString("Email");
        this.about = obj.getString("About");
        this.cnpj = obj.getString("CNPJ");
        phone = obj.getString("Phone");
        creationDate = obj.getString("Creation_Date");
        isActive = obj.getBoolean("Is_Active");
        this.socialReason = obj.getString("SocialReason");
        this.fantasyName = obj.getString("FantasyName");
    }
}
