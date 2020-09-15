package com.bandtech.eventech.model.V2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class UserJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String password;
    private String surname;
    private String email;
    private String sex;
    private LocalDate dateBorn ;
    private String cpf ;
    private String phone ;
    private String creationDate;
    private int companyId;
    private boolean isActive;
    private boolean isCompany;

    public UserJPA() {
    }

    public UserJPA(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserJPA(int id, String name, String password, String surname, String email, String sex, LocalDate dateBorn
            , String cpf, String phone, String creationDate, int companyId, boolean isActive, boolean isCompany) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.sex = sex;
        this.dateBorn = dateBorn;
        this.cpf = cpf;
        this.phone = phone;
        this.creationDate = creationDate;
        this.companyId = companyId;
        this.isActive = isActive;
        this.isCompany = isCompany;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(LocalDate dateBorn) {
        this.dateBorn = dateBorn;
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

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public boolean isCompany() {
        return isCompany = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
