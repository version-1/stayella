package group1.stayella.HotelFacility;

public class StoreLuggage extends HotelFacility {
    private int numberOfLuggage;

    public StoreLuggage(int id, String key, String label, boolean value, int numberOfLuggage) {
        super(id, key, label, value);
        this.numberOfLuggage = numberOfLuggage;
    }

    public int getNumberOfLuggage() {
        return numberOfLuggage;
    }

    public void setNumberOfLuggage(int numberOfLuggage) {
        this.numberOfLuggage = numberOfLuggage;
    }
}
