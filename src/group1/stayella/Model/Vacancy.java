package group1.stayella.Model;

import java.util.Date;

public class Vacancy {
    private int id;
    private String roomNumber;
    private Reservation reservation;
    private Date startTime;
    private Date endTime;

    public  Vacancy() {}

    public Vacancy(int id, String roomNumber, Reservation reservation, Date startTime, Date endTime) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.reservation = reservation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isOccupied() {
        if (reservation == null) {
            return false;
        }
        return reservation.isLocked();
    }

    public int getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public Reservation getReservation() {
        return reservation;
    }

    public Date getStartTime() {
        return startTime;
    }


    public Date getEndTime() {
        return endTime;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
