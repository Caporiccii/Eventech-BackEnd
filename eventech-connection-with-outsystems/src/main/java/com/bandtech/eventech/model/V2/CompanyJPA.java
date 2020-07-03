package com.bandtech.eventech.model.V2;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

    public CompanyJPA(String nameCompany, String password) {
        this.name = nameCompany;
        this.password = password;
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
