package com.bandtech.eventech.model.V2;

import lombok.*;
import org.json.JSONObject;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data

public class PlaceJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;
    private int AddressId;
    private String Description;
    private int Capacity;

}
