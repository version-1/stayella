package group1.stayella.Model.HotelFacility;

public class Gym extends HotelFacility {
    private String key = "gym";
    private String label = "Gym";

    public Gym(int id, double price, double capcity) {
        super(id, price, capcity);
    }


    public String getLabel() {
        return label;
    }
}
