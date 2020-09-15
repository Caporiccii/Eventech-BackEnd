package com.bandtech.eventech.model.V1;

import org.json.JSONObject;


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

    public User() {
    }
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
