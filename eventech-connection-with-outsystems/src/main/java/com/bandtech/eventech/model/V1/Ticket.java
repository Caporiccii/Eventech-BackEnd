package com.bandtech.eventech.model.V1;



import org.json.JSONObject;

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

    public Ticket(){

    }

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

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getQtdPerPerson() {
        return qtdPerPerson;
    }

    public void setQtdPerPerson(int qtdPerPerson) {
        this.qtdPerPerson = qtdPerPerson;
    }

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public boolean isPayment() {
        return isPayment;
    }

    public void setPayment(boolean payment) {
        isPayment = payment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
