package group1.stayella.Model.HotelFacility;

public class ExtraBed extends HotelFacility {
    private int capacityOfBeds;

    public ExtraBed(int id, String key, String label, double price, int capacityOfBeds) {
        super(id, key, label, price);
        this.capacityOfBeds = capacityOfBeds;
    }

    public int getCapacityOfBeds() {
        return capacityOfBeds;
    }

    public void setCapacityOfBeds(int capacityOfBeds) {
        this.capacityOfBeds = capacityOfBeds;
    }
}
