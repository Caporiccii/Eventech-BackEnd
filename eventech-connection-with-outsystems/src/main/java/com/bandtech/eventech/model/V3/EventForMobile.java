package com.bandtech.eventech.model.V3;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class EventForMobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEventMobile;

    public String name;
    public String initialDate;
    public String finalDate;
    public String initialHour;
    public String finalHour;
    public int createdBy;
    public String description;
    public String imageSource;
    public String city;
    public BigDecimal price;
    public String category;
    public String link;
    public String cep;
    public Integer ticketId;

    public EventForMobile(int idEventMobile, String name, String initialDate, String finalDate, String initialHour,
                          String finalHour, int createdBy, String description, String imageSource, String city,
                          BigDecimal price, String category, String link, String cep, Integer ticketId) {
        this.idEventMobile = idEventMobile;
        this.name = name;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.initialHour = initialHour;
        this.finalHour = finalHour;
        this.createdBy = createdBy;
        this.description = description;
        this.imageSource = imageSource;
        this.city = city;
        this.price = price;
        this.category = category;
        this.link = link;
        this.cep = cep;
        this.ticketId = ticketId;
    }

    public EventForMobile(int idEventMobile, String name, String initialDate, String finalDate, String initialHour,
                          String finalHour, int createdBy, String description,
                          String imageSource, String city, BigDecimal price, String category) {
        this.idEventMobile = idEventMobile;
        this.name = name;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.initialHour = initialHour;
        this.finalHour = finalHour;
        this.createdBy = createdBy;
        this.description = description;
        this.imageSource = imageSource;
        this.city = city;
        this.price = price;
        this.category = category;
    }

    public EventForMobile(String name,BigDecimal price,
                          String category,String cep,
                          String initialDate, String initialHour) {
        this.name = name;
        this.category = category;
        this.cep = cep;
        this.price = price;
        this.initialHour = initialHour;
        this.initialDate = initialDate;
    }

    public EventForMobile() {
    }

    public int getId() {
        return idEventMobile;
    }

    public void setId(int idEventMobile) {
        this.idEventMobile = idEventMobile;
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

    public String getInitialHour() {
        return initialHour;
    }

    public void setInitialHour(String initialHour) {
        this.initialHour = initialHour;
    }

    public String getFinalHour() {
        return finalHour;
    }

    public void setFinalHour(String finalHour) {
        this.finalHour = finalHour;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
