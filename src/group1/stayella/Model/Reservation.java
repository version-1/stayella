package group1.stayella.Model;

import group1.stayella.Model.HotelFacility.HotelFacility;

import java.util.ArrayList;
import java.util.Date;


public class Reservation {
    private int id;
    private String reservationNo;
    private Charges charges;
    private Guest mainGuest;
    private int numberOfGuest;
    private ArrayList<HotelFacility> hotelFacilities;
    private Date checkInTime;
    private Date checkOutTime;
    private int status;
    // e.g 0: cancel 1:unconfirmed 2:

    public  Reservation(){}

    public Reservation(int id, String reservationNo, Charges charges, Guest guest, int numberOfGuest, Date checkInTime, Date checkOutTime, int status) {
        this.id = id;
        this.reservationNo = reservationNo;
        this.charges = charges;
        this.mainGuest = guest;
        this.numberOfGuest = numberOfGuest;
        this.hotelFacilities = new ArrayList<>();
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Charges getCharges() {
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

    public ArrayList<HotelFacility> getHotelFacilities() {
        return hotelFacilities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCharges(Charges charges) {
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

    public void setHotelFacilities(ArrayList<HotelFacility> hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
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
