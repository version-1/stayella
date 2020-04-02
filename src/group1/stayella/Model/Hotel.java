package group1.stayella.Model;

import group1.stayella.Model.HotelFacility.HotelFacility;

import java.util.ArrayList;

public class Hotel {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String url;
    private int deposit;
    private int parkingCapacity;
    private ArrayList<Room> rooms;
    private ArrayList<HotelFacility> facilities;

    public Hotel() {
    }

    public Hotel(int id, String name, String address, String phoneNumber, String email, String url, int deposit, int numberOfRooms, int parkingCapacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.url = url;
        this.deposit = deposit;
        this.parkingCapacity = parkingCapacity;
        this.rooms = new ArrayList<>();
        this.facilities = new ArrayList<>();
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParkingCapacity(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    // getter
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUrl() {
        return url;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }


    public ArrayList<HotelFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<HotelFacility> facilities) {
        this.facilities = facilities;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
