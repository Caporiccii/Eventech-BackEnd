package com.bandtech.eventech.model.V2;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTicket;

    public String name;
    public String initialDate;
    public String finalDate;
    public String initialTime;
    public String finalTime;
    public int eventId;
    public int qtd;
    public int qtdPerPerson;
    public int buyer;
    public boolean isPayment;
    public double price;

    public TicketJPA() {
    }

    public TicketJPA(int id, String name, String initialDate, String finalDate, String initialTime, String finalTime,
                     int eventId, int qtd, int qtdPerPerson, int buyer, boolean isPayment, double price) {
        this.idTicket = id;
        this.name = name;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.initialTime = initialTime;
        this.finalTime = finalTime;
        this.eventId = eventId;
        this.qtd = qtd;
        this.qtdPerPerson = qtdPerPerson;
        this.buyer = buyer;
        this.isPayment = isPayment;
        this.price = price;
    }


    public int getIdEvent() {
        return idTicket;
    }

    public void setIdEvent(int idEvent) {
        this.idTicket = idEvent;
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

    public String getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(String initialTime) {
        this.initialTime = initialTime;
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
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
