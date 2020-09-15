package com.bandtech.eventech.model.V1;


import org.json.JSONObject;

import java.time.LocalDateTime;

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


    public Company() {
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }
}
