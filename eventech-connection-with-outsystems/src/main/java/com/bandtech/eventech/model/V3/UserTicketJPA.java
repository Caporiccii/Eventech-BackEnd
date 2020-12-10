package com.bandtech.eventech.model.V3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserTicketJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ticket_user;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer ticketId;
    private String reservateDate;
    private Integer statusId;
    private Integer eventId;
    private String ticketName;

    public UserTicketJPA(){

    }

    public UserTicketJPA(Integer id_ticket_user, @NotNull Integer userId, @NotNull Integer ticketId,
                         String reservateDate, Integer statusId, Integer eventId, String ticketName) {
        this.id_ticket_user = id_ticket_user;
        this.userId = userId;
        this.ticketId = ticketId;
        this.reservateDate = reservateDate;
        this.statusId = statusId;
        this.eventId = eventId;
        this.ticketName = ticketName;
    }

    public UserTicketJPA(Integer id_ticket_user, @NotNull Integer userId, @NotNull Integer ticketId, String reservateDate, Integer statusId) {
        this.id_ticket_user = id_ticket_user;
        this.userId = userId;
        this.ticketId = ticketId;
        this.reservateDate = reservateDate;
        this.statusId = statusId;
    }

    public Integer getId_ticket_user() {
        return id_ticket_user;
    }

    public void setId_ticket_user(Integer id_ticket_user) {
        this.id_ticket_user = id_ticket_user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getReservateDate() {
        return reservateDate;
    }

    public void setReservateDate(String reservateDate) {
        this.reservateDate = reservateDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
}
