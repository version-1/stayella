package group1.stayella.Model.HotelFacility;

public abstract class HotelFacility {
    private int id;
    private String key;
    private String label;
    private double price;

    public HotelFacility(int id, String key, String label, double price){
        this.id = id;
        this.key = key;
        this.label = label;
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


    public void setId(int id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice( double price) {
        this.price = price;
    }
}
