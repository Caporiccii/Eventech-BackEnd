package com.bandtech.eventech.model.V2;

import lombok.*;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate creationDate;
    private int companyId;
    private boolean isActive;

    public UserJPA(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
