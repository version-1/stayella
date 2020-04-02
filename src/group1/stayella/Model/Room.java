package group1.stayella.Model;

import java.util.ArrayList;

public class Room {
    private String roomNumber;
    private int roomCapacity;
    private double roomPrice;
    // private int roomCategory;
    private String bedType;
    private int numberOfBeds;
    private boolean vacancy = false;
    private boolean damage = false;
    private boolean refrigerator = false;
    private boolean petAllowed = false;
    private boolean balcony = false;
    private boolean view = false;
    private boolean kitchen = false;
    // extra person

    private ArrayList<Vacancy> vacancies;



    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        if (roomNumber.charAt(0) == 1) {
            this.roomCapacity = 2;
            this.roomPrice = 100.00;
            this.bedType = "king size";
            this.numberOfBeds = 1;
            this.petAllowed = true;
        } else if (roomNumber.charAt(0) == 2 || roomNumber.charAt(0) == 3) {
            this.roomCapacity = 3;
            this.roomPrice = 250.00;
            this.bedType = "king size";
            this.numberOfBeds = 1;
            this.petAllowed = true;
            this.kitchen = true;
        } else if (roomNumber.charAt(0) == 4 || roomNumber.charAt(0) == 5) {
            this.roomCapacity = 4;
            this.roomPrice = 450.00;
            this.bedType = "queen size";
            this.numberOfBeds = 2;
            this.kitchen = true;
            this.balcony = true;
        } else if (roomNumber.charAt(0) == 6) {
            this.roomCapacity = 6;
            this.roomPrice = 850.00;
            this.bedType = "king size & queen size";
            this.numberOfBeds = 3;
            this.petAllowed = true;
            this.kitchen = true;
        }
        if (roomNumber.charAt(2) == 1 || roomNumber.charAt(2) == 2 || roomNumber.charAt(2) == 3) {
            this.view = true;
        }

        this.vacancies = new ArrayList<>();
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setVacancy(boolean vacancy) {
        this.vacancy = vacancy;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
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

    public boolean isVacant() {
        return vacancy;
    }

    public boolean isDamage() {
        return damage;
    }

    public boolean hasRefrigerator() {
        return refrigerator;
    }

    public boolean isPetAllowed() {
        return petAllowed;
    }

    public boolean hasBalcony() {
        return balcony;
    }

    public boolean hasView() {
        return view;
    }

    public boolean hasKitchen() {
        return kitchen;
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
}
