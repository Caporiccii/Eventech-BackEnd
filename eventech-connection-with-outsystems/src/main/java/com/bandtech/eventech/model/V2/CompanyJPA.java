package com.bandtech.eventech.model.V2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class CompanyJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean isCompany;
    public CompanyJPA() {
    }

    public CompanyJPA(String nameCompany, String password) {
        this.name = nameCompany;
        this.password = password;
    }

    public CompanyJPA(int id, String name, String password, String email, String about, String cnpj, String phone,
                      String creationDate, boolean isActive, String socialReason, String fantasyName, boolean isCompany) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.about = about;
        this.cnpj = cnpj;
        this.phone = phone;
        this.creationDate = creationDate;
        this.isActive = isActive;
        this.socialReason = socialReason;
        this.fantasyName = fantasyName;
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

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public boolean isCompany() {
        return isCompany = true;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
