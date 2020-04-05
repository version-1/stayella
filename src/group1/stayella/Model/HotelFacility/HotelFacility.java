package group1.stayella.Model.HotelFacility;

import group1.stayella.Model.Facility;

public abstract class HotelFacility implements Facility {
    private int id;
    private String key;

    private int capacity;
    private double price;

    public static HotelFacility getInstance(String key, int id, double price, double capacity) {
        HotelFacility res;
        switch(key) {
            case "gym":
              res = new Gym(id, price, capacity);
              break;
            case "luggage":
              res = new StoreLuggage(id, price, capacity);
              break;
            case "extraBed":
              res = new ExtraBed(id, price, capacity);
              break;
            case "foodService":
              res = new FoodService(id, price, capacity);
              break;
            case "washingRoom":
              res = new WashingRoom(id, price, capacity);
              break;
            case "parking":
              res = new Parking(id, price, capacity);
              break;
            default:
              // code block
              throw new Error("can't resolved HotelFacility key");
          }

        return res;
    }

    public HotelFacility(int id, double price, double capcity){
        this.id = id;
        this.price = price;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }


    public double getPrice() {
        return price;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public void setPrice( double price) {
        this.price = price;
    }

    public void setCapcity(int capacity) {
        this.capacity = capacity;
    }
}
