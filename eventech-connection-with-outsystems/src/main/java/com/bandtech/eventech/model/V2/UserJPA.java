package com.bandtech.eventech.model.V2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class UserJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    private String nameUser;
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
        this.nameUser = name;
        this.password = password;
    }

    public UserJPA(int id, String nameUser, String password, String surname, String email, String sex, LocalDate dateBorn
            , String cpf, String phone, String creationDate, int companyId, boolean isActive, boolean isCompany) {
        this.idUser = id;
        this.nameUser = nameUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return nameUser;
    }

    public void setName(String nameUser) {
        this.nameUser = nameUser;
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
