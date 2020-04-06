package group1.stayella.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
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
    private Date checkInTime;
    private Date checkOutTime;
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



    public boolean isLocked() {
        return status != CANCEL;
    }

    // make the reservation
    public boolean make(List<Vacancy> vacancies, Date start, int lengthOfStay) {
        if (vacancies.size() == 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(Calendar.DATE, lengthOfStay);
        Date end = calendar.getTime();
        for (Vacancy vacancy: vacancies) {
            boolean isInclude = start.compareTo(vacancy.getEndTime()) <= 0 &&
                end.compareTo(vacancy.getStartTime()) >= 0;
            if (isInclude) {
                if (vacancy.isOccupied()) {
                    return false;
                }
                vacancy.setReservation(this);
                this.vacancies.add(vacancy);
            }
        }
        assignReservationNo();
        return true;
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
