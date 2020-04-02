package group1.stayella.Model;

import java.util.ArrayList;

public class Room {
    private String roomNumber;
    private boolean damage = false;
    private double roomPrice;
    // private ArrayList<>

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
    }

    public boolean isDamage() {
        return damage;
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
