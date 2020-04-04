package group1.stayella.Model.HotelFacility;

public class ExtraBed extends HotelFacility {
    public ExtraBed(int id, double price, double capcity) {
        super(id, price, capcity);
    }

    private String key = "extraBed";
    private String label = "Extra Bed";
}
