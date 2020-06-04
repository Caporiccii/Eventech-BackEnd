package com.bandtech.eventech.model.V2;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AddressJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String city;
    private String state;
    private String zipCode;
    private String street;
    private int streetNumber;
}
