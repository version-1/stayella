package group1.stayella.Model;

import group1.stayella.Model.RoomFacility.RoomFacility;

import java.util.ArrayList;

public class Room {
    private String roomNumber;
    private int capacity;
    private double price;
    private String bedType;
    private int numberOfBeds;
    //    private int roomCategory;
//    private boolean vacancy = false;
//    private boolean damage = false;
//    private boolean refrigerator = false;
//    private boolean petAllowed = false;
//    private boolean balcony = false;
//    private boolean view = false;
//    private boolean kitchen = false;
    // extra person
    private ArrayList<RoomFacility> facilities;
    private ArrayList<Vacancy> vacancies;
    private int status;

    public Room(String roomNumber, int capacity, double price, String bedType, int numberOfBeds, int status) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.bedType = bedType;
        this.numberOfBeds = numberOfBeds;
        this.facilities = new ArrayList<>();
        this.vacancies = new ArrayList<>();
        this.status = status;
    }


//    public Room(String roomNumber) {
//        this.roomNumber = roomNumber;
//        if (roomNumber.charAt(0) == 1) {
//            this.capacity = 2;
//            this.price = 100.00;
//            this.bedType = "king size";
//            this.numberOfBeds = 1;
//            this.petAllowed = true;
//        } else if (roomNumber.charAt(0) == 2 || roomNumber.charAt(0) == 3) {
//            this.capacity = 3;
//            this.price = 250.00;
//            this.bedType = "king size";
//            this.numberOfBeds = 1;
//            this.petAllowed = true;
//            this.kitchen = true;
//        } else if (roomNumber.charAt(0) == 4 || roomNumber.charAt(0) == 5) {
//            this.capacity = 4;
//            this.price = 450.00;
//            this.bedType = "queen size";
//            this.numberOfBeds = 2;
//            this.kitchen = true;
//            this.balcony = true;
//        } else if (roomNumber.charAt(0) == 6) {
//            this.capacity = 6;
//            this.price = 850.00;
//            this.bedType = "king size & queen size";
//            this.numberOfBeds = 3;
//            this.petAllowed = true;
//            this.kitchen = true;
//        }
//        if (roomNumber.charAt(2) == 1 || roomNumber.charAt(2) == 2 || roomNumber.charAt(2) == 3) {
//            this.view = true;
//        }
//
//    }

    public void setRoomPrice(double price) {
        this.price = price;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRoomPrice() {
        return price;
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

    public void setVacancies(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
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
