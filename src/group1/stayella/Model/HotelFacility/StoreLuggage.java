package group1.stayella.Model.HotelFacility;

public class StoreLuggage extends HotelFacility {
    private int capacityOfLuggage;

    public StoreLuggage(int id, String key, String label, double price, int capacityOfLuggage) {
        super(id, key, label, price);
        this.capacityOfLuggage = capacityOfLuggage;
    }


    public int getCapacityOfLuggage() {
        return capacityOfLuggage;
    }

    public void setCapacityOfLuggage(int capacityOfLuggage) {
        this.capacityOfLuggage = capacityOfLuggage;
    }
}
