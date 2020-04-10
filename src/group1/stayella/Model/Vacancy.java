package group1.stayella.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.TableCell;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

public class Vacancy {
    public final static String CALENDAR_DATE_FORMAT = "yyyy.MM.dd";
    public final static String CALENDAR_TIME_FORMAT = "HH:mm";
    public final static String CALENDAR_DATETIME_FORMAT = "yyyy/MM/dd HH:mm";

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
            return -100;
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
        return reservation.getVacancies().get(0).id == id;
    }

    public String getReservationNo() {
        return reservation.getReservationNo();
    }

    public String getReservationText() {
        if (reservation == null || !isFirstVacantForRervation()) {
            return null;
        }

        return String.format("%s x %s\n - %s", reservation.getMainGuest().getName(), reservation.getNumberOfGuest(),
                getDateString(startTime, CALENDAR_DATETIME_FORMAT));
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

    public void decorate(TableCell cell) {
        cell.getStyleClass().add(getFilledClass());
        if (isFirstVacantForRervation()) {
            BorderStroke stroke = new BorderStroke(
                null,
                null,
                null,
                Color.ORANGE,
                null,
                null,
                null,
                BorderStrokeStyle.SOLID,
                null,
                new BorderWidths(5),
                null
            );
            cell.setBorder(new Border(stroke));
        }
        cell.getStyleClass().add(getFilledClass());
        cell.setText(getReservationText());
        cell.setId(getReservationNo());
    }
}
