package group1.stayella.Model.HotelFacility;

public class WashingRoom extends HotelFacility{
    public WashingRoom(int id, double price, double capcity) {
        super(id, price, capcity);
    }

    private String key = "washingRoom";
    private String label = "Washing Room";

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "WashingRoom{" +
                "label='" + label +
                '}';
    }
}
