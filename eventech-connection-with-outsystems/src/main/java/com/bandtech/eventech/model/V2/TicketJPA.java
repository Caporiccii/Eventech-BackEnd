package com.bandtech.eventech.model.V2;


import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="TicketJPA", entities={
        @EntityResult(
                entityClass = com.bandtech.eventech.model.V2.TicketJPA.class
        )}
)
@Entity
public class TicketJPA implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTicket;

    public String name;
    public String initialDate;
    public String finalDate;
    public int event_Id;
    public int qtd;
    public int qtdPerPerson;
    public int buyer;
    public boolean isPayment;
    public double price;
    public int fk_event;

    public TicketJPA() {
    }

    public TicketJPA(int idTicket, String name, String initialDate, String finalDate, int eventId, int qtd,
                     int qtdPerPerson, int buyer, boolean isPayment, double price, int fk_event) {
        this.idTicket = idTicket;
        this.name = name;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.event_Id = eventId;
        this.qtd = qtd;
        this.qtdPerPerson = qtdPerPerson;
        this.buyer = buyer;
        this.isPayment = isPayment;
        this.price = price;
        this.fk_event = fk_event;
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

    public int getEvent_Id() {
        return event_Id;
    }

    public void setEvent_Id(int event_Id) {
        this.event_Id = event_Id;
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

    @ManyToOne
    @JoinColumn(name = "idEventMobile")
    public int getFk_event() {
        return fk_event;
    }

    public void setFk_event(int fk_event) {
        this.fk_event = fk_event;
    }
}
