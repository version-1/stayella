package group1.stayella.Model;

import java.util.Date;


public class Reservation {
    private int id;
    private String ReservationNo;
    private Charge charges;
    private Guest guest;
    private group1.stayella.Model.HotelFacility.HotelFacility hotelFacilities[];
    private Date CheckInTime;
    private Date CheckOutTime;
    private int status;


    public Reservation(int id, String ReservationNo, Charge charges,Guest guest, Date CheckInTime, Date CheckOutTime, int status) {

    }
}
