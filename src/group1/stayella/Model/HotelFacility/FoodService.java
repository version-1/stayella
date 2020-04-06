package group1.stayella.Model.HotelFacility;

public class FoodService extends HotelFacility {
    private String key = "foodService";
    private String label = "Food Service";

    public FoodService(int id, double price, double capcity) {
        super(id, price, capcity);
        // TODO Auto-generated constructor stub
    }


    public String getLabel() {
        return label;
    }
}
