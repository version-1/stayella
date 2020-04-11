package group1.stayella.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;


public class Reservation {
    private final static int CANCEL = 0;
    private final static int UNCONFIRMED = 0;
    private final static int CONFIRMED = 0;

    private static int index = 1;
    private int id;
    private String reservationNo;
    private List<Charge> charges = new ArrayList<Charge>();
    private List<Vacancy> vacancies = new ArrayList<Vacancy>();
    private Guest mainGuest;
    private int numberOfGuest;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;
    private Room room;
    private int status;

    // e.g 0: cancel 1:unconfirmed 2: confirmed

    public  Reservation(){
       index++;
    }

    public Reservation(Guest guest, int numberOfGuest, int status) {
        this.id = index;
        this.mainGuest = guest;
        this.numberOfGuest = numberOfGuest;
        this.status = status;

        index++;
    }

    public Room getRoom() {
        return room;
    }

    public int getId() {
        return id;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public LocalDate getCheckInTime() {
        return checkInTime;
    }

    public LocalDate getCheckOutTime() {
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

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public boolean setCheckInTime(LocalDate checkInTime) {
        LocalDate today = LocalDate.now();
        if (checkTheDate(today, checkInTime)) {
             this.checkInTime = checkInTime;
             return true;
        }
        return false;
    }

    public boolean setCheckOutTime(LocalDate checkOutTime) {
        if (checkTheDate(checkInTime, checkOutTime)) {
            this.checkOutTime = checkOutTime;
            return true;
        }
        return false;
    }

    public void setMainGuest(Guest guest) {
        this.mainGuest = guest;
    }

    public void assignReservationNo() {
        if (reservationNo != null || vacancies.size() == 0) {
            return;
        }
        Vacancy vacancy = vacancies.get(0);
        reservationNo = String.format("%s0000%06d", vacancy.getRoomNumber(), id);
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

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isLocked() {
        return status != CANCEL;
    }

    // make the reservation
    public boolean make(List<Vacancy> vacancies, LocalDate start, int lengthOfStay) {
       return reserve(vacancies, start, lengthOfStay);
    }

    public boolean make(Room room, LocalDate start, int lengthOfStay) {
       boolean res = reserve(room.getVacancies(), start, lengthOfStay);
       if (res) {
         setRoom(room);
       }
       return res;
    }

    private boolean reserve(List<Vacancy> vacancies, LocalDate start, int lengthOfStay) {
        if (vacancies.size() == 0) {
            return false;
        }
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //local date + atStartOfDay() + default time zone + toInstant() = Date
        Date date = Date.from(start.atStartOfDay(defaultZoneId).toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, lengthOfStay);
        Date end = calendar.getTime();
        for (Vacancy vacancy: vacancies) {
            boolean isInclude = date.compareTo(vacancy.getEndTime()) <= 0 &&
                end.compareTo(vacancy.getStartTime()) >= 0;
            if (isInclude) {
                if (vacancy.isOccupied()) {
                    return false;
                }
                vacancy.setReservation(this);
                this.vacancies.add(vacancy);
            }
        }
        this.vacancies.sort((a, b) -> { return a.compareTo(b); });
        assignReservationNo();
        return true;
    }

    // check the input
    // Date validation
    private boolean checkTheDate(LocalDate before, LocalDate settingTime){
        if (before.isAfter(settingTime)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationNo='" + reservationNo + '\'' +
                ", charges=" + charges +
                ", room=" + room +
                ", numberOfGuest=" + numberOfGuest +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", status=" + status +
                '}';
    }
}
