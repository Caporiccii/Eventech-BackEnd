package com.bandtech.eventech.model.V2;

public class History {

    private String nameEvent;
    private String nameCompany;
    private String nameCategory;

    public History() {
    }

    public History(String nameEvent, String nameCompany, String nameCategory) {
        this.nameEvent = nameEvent;
        this.nameCompany = nameCompany;
        this.nameCategory = nameCategory;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
