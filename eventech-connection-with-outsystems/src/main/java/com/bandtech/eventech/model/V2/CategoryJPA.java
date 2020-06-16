package com.bandtech.eventech.model.V2;

import lombok.*;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoryName;
    private String Description;


}
