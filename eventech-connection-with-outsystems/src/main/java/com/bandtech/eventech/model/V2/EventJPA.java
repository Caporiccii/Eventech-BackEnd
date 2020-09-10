package com.bandtech.eventech.model.V2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EventJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String initialDate;
    public String finalDate;
    public String initialHour;
    public String finalHour;
    public int categoryId;
    public int placeId;
    public int createdBy;
    public String description;
    public boolean isCancelled;
    public String ageRange;

    public EventJPA() {
    }

    public EventJPA(int id, String name, String initialDate, String finalDate, String initialHour, String finalHour,
                    int categoryId, int placeId, int createdBy, String description, boolean isCancelled, String ageRange) {
        this.id = id;
        this.name = name;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.initialHour = initialHour;
        this.finalHour = finalHour;
        this.categoryId = categoryId;
        this.placeId = placeId;
        this.createdBy = createdBy;
        this.description = description;
        this.isCancelled = isCancelled;
        this.ageRange = ageRange;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
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

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
}
