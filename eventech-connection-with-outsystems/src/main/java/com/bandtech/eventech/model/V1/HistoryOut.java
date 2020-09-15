package com.bandtech.eventech.model.V1;



import org.json.JSONObject;


public class HistoryOut {

    private Long id;
    private String Name;
    private String image;
    private String initialDate;
    private String finalDate;
    private String category;

    public HistoryOut() { }

    public HistoryOut(JSONObject obj) {
        this.id =  obj.getLong("Id");
        Name = obj.getString("Name");
        image = obj.getString("Image");
        initialDate = obj.getString("InitialDate");
        finalDate = obj.getString("FinalDate");
        category = obj.getString("Category");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
