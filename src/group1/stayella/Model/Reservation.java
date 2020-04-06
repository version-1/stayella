package group1.stayella.Model;

import group1.stayella.Model.HotelFacility.HotelFacility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Reservation {
    private int id;
    private String reservationNo;
    private List<Charge> charges;
    private Guest mainGuest;
    private int numberOfGuest;
    private Date checkInTime;
    private Date checkOutTime;
    private int status;
    private double totalPrice;
    private List<HotelFacility> hotelFacilities;
    // e.g 0: cancel 1:unconfirmed 2:

    public  Reservation(){}

    public Reservation(int id, String reservationNo, Guest guest, int numberOfGuest, Date checkInTime, Date checkOutTime, int status, double price) {
        this.id = id;
        this.reservationNo = reservationNo;
        this.mainGuest = guest;
        this.numberOfGuest = numberOfGuest;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.status = status;
        this.totalPrice = price;
        this.hotelFacilities = new ArrayList<HotelFacility>();
    }

    public int getId() {
        return id;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public Guest getMainGuest() {
        return mainGuest;
    }

    public int getStatus() {
        return status;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<HotelFacility> getHotelFacilities() {
        return (ArrayList) hotelFacilities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public void setCheckInTime(Date checkInTime) {
        Date today = new Date();
        if(checkTheDate(today, checkInTime)){this.checkInTime = checkInTime;}
    }

    public void setCheckOutTime(Date checkOutTime) {
        if(checkTheDate(checkInTime, checkOutTime)) {
            this.checkOutTime = checkOutTime;
        }
    }

    public void setMainGuest(Guest guest) {
        this.mainGuest = guest;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setHotelFacilities(List<HotelFacility> hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
    }

    // check the input
    // Date validation
    private boolean checkTheDate(Date before, Date settingTime){
        if(before.after(settingTime)) {
            return false;
        }else {
            return true;
        }
    }
}
