package com.bandtech.eventech.model.V3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class EventForMobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

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


    public EventForMobile(int id, String name, String initialDate, String finalDate, String initialHour,
                          String finalHour, int createdBy, String description,
                           String imageSource, String city, BigDecimal price, String category) {
        this.id = id;
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

    public EventForMobile() {
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
}
