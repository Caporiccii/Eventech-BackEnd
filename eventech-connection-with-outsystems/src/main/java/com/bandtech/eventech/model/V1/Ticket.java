package com.bandtech.eventech.model.V1;


import lombok.*;
import org.json.JSONObject;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
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


    public Ticket(JSONObject obj) {
        this.id = obj.getInt("Id");
        name = obj.getString("Name");
        initialDate = obj.getString("InitialDate");
        finalDate = obj.getString("FinalDate");
        eventId = obj.getInt("EventId");
        qtd = obj.getInt("Qtd") ;
        qtdPerPerson = obj.getInt("QtdPerPerson") ;
        buyer = obj.getInt("Buyer");
        isPayment = obj.has("IsPayment");
        price = obj.getDouble("Price");
    }
    public Ticket(JSONObject objeto, boolean isReturn) {
        this.id = objeto.getInt("Id");
        name = objeto.getString("Name");
        initialDate = objeto.getString("InitialDate");
        finalDate = objeto.getString("FinalDate");
        eventId = objeto.getInt("EventId");
        buyer = objeto.getInt("Buyer");
        isPayment = objeto.has("IsPayment");
        price = objeto.getDouble("Price");
        isReturn = true;
    }

}
