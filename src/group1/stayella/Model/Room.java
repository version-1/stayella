package group1.stayella.Model;

import java.util.ArrayList;

public class Room {
    private final static int VACANT = 0;
    private final static int OCCUPIED = 100;
    private final static int DIRTY = 200;

    private int id;
    private int hotelId;
    private String roomNumber;
    private int roomCapacity;
    private double roomPrice;
    private int status;
    private int numberOfBeds;
    private String bedType;
    private ArrayList<Vacancy> vacancies;
    private ArrayList<RoomFacility> facilities;


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

    public void setVacancies(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public String getBedType() {
        return bedType;
    }


    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public ArrayList<Vacancy> getVacancies() {
        return vacancies;
    }

    public ArrayList<RoomFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<RoomFacility> facilities) {
        this.facilities = facilities;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
