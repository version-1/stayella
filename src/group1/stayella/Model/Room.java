package group1.stayella.Model;

public class Room {
    private final static int VACANT = 0;
    private final static int OCCUPIED = 100;
    private final static int DURTY = 200;

    private int id;
    private int hotelId;
    private String roomNumber;
    private int roomCapacity;
    private double roomPrice;
    private int status;
    private int numberOfBeds;
    private String bedType;


    public Room(int id, int hotelId, String number, int capacity, double price, String bedType, int numberOfBeds, int status) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomNumber = number;
        this.roomCapacity = capacity;
        this.roomPrice = price;
        this.numberOfBeds = numberOfBeds;
        this.bedType = bedType;
        this.status = status;
    }

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }
}
