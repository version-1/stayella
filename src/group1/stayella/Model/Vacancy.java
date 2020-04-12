package group1.stayella.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Vacancy implements Comparable {
    public final static String CALENDAR_DATE_FORMAT = "yyyy.MM.dd";
    public final static String CALENDAR_TIME_FORMAT = "HH:mm";
    public final static String CALENDAR_DATETIME_FORMAT = "yyyy/MM/dd HH:mm";

    public final static int HOUR_SPAN = 12;
    public final static int NUMBER_OF_VACANCY_PER_DAY = 24 / HOUR_SPAN;

    public final static int VACANT = -100;
    private int id;
    private Room room;
    private Reservation reservation;
    private Date startTime;
    private Date endTime;

    public Vacancy() {
    }

    public Vacancy(int id, Room room, Reservation reservation, Date startTime, Date endTime) {
        this.id = id;
        this.room = room;
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

    public int getStatus() {
        if (reservation == null) {
            return VACANT;
        }
        return reservation.getStatus();
    }

    public String getRoomNumber() {
        return room.getRoomNumber();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getStartTimeString() {
        return getDateString(startTime, CALENDAR_DATETIME_FORMAT);
    }

    public Date getEndTime() {
        return endTime;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isFirstVacantForRervation() {
        if (reservation == null || reservation.getVacancies().size() == 0) {
            return false;
        }
        return reservation.getVacancies().get(0).id == id;
    }

    public String getReservationNo() {
        return reservation.getReservationNo();
    }

    public String getReservationText() {
        if (reservation == null || !isFirstVacantForRervation()) {
            return null;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(reservation.getEndDate());
        c.add(Calendar.DATE, -1);
        Date end = c.getTime();

        return String.format(
            "%s + %s\n %s - %s",
            reservation.getMainGuest().getName(),
            reservation.getNumberOfGuest(),
            getDateString(reservation.getStartDate(), CALENDAR_DATE_FORMAT),
            getDateString(end, CALENDAR_DATE_FORMAT)
            );
    }

    public String getFilledClass() {
        if (room == null) {
            return null;
        }

        int divider = 3;
        if (room.getID() % divider == 1) {
            return "occupied-cell-1";
        } else if (room.getID() % divider == 2) {
            return "occupied-cell-2";
        }
        return "occupied-cell-3";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public static String getDateString(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    @Override
    public int compareTo(Object o) {
        Vacancy v = (Vacancy) o;

        return startTime.compareTo(v.getStartTime());
    }

	public int compareTo(Vacancy b) {
        return compareTo((Object)b);
	}
}
