package group1.stayella.Model.RoomFacility;

import group1.stayella.Model.Facility;

public abstract class RoomFacility implements Facility {
    private int id;
    private String key;
    private String label;
    private double price;

    public RoomFacility(int id, String key, String label, double price){
        this.id = id;
        this.key = key;
        this.label = label;
        this.price = price;
    }

    public RoomFacility(int id, String key, String label){
        this.id = id;
        this.key = key;
        this.label = label;
        this.price = 0.0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }

    public Double getPrice() {
        return price;
    }
}
