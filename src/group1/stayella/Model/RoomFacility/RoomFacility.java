package group1.stayella.Model.RoomFacility;

import group1.stayella.Model.Facility;

public abstract class RoomFacility implements Facility {
    private int id;
    private String key;
    private String label;
    private double price;

    public static RoomFacility getInstance(String key, int id, double price) {
        RoomFacility res;
        switch(key) {
            case "pet":
              res = new Pet(id, price);
              break;
            case "kitchen":
              res = new Kitchen(id, price);
              break;
            case "accecibleForDisabilities":
              res = new AccessibleForDisabilities(id, price);
              break;
            case "balcony":
              res = new Balcony(id, price);
              break;
            case "bath":
              res = new Bath(id, price);
              break;
            case "refrigerator":
              res = new Refrigerator(id, price);
              break;
            case "smorking":
              res = new Smorking(id, price);
              break;
            case "view":
              res = new View(id, price);
              break;
            default:
              // code block
              throw new Error("can't resolved RoomFacility key");
          }
        return res;
    }


    public RoomFacility(int id, double price){
        this.id = id;
        this.price = price;
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

    public double getPrice() {
        return price;
    }
}
