package group1.stayella.Model.HotelFacility;

public class StoreLuggage extends HotelFacility {
    private String key = "storeLagguage";
    private String label = "Store Luggage";

    public StoreLuggage(int id, double price, double capcity) {
        super(id, price, capcity);
    }


    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "StoreLuggage{" +
                "label='" + label +
                '}';
    }
}
