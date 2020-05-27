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
public class TicketJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String initialDate;
    public String finalDate;
    public int eventId;
    public int qtd;
    public int qtdPerPerson;
    public int buyer;
    public boolean isPayment;
    public double price;

}
