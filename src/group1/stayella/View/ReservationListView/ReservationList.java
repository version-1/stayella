package group1.stayella.View.ReservationListView;

import group1.stayella.Model.Reservation;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sun.awt.XSettings;

import java.time.LocalDate;

public class ReservationList {
    private final static int CANCEL = 0;
    private final static int UNCONFIRMED = 1;
    private final static int CONFIRMED = 2;

    private final SimpleIntegerProperty reservationId;
    private final SimpleStringProperty reservationNo;
    private final SimpleStringProperty status;
    private final SimpleStringProperty checkIn;
    private final SimpleStringProperty checkOut;
    private final SimpleStringProperty roomNumber;
    private final SimpleIntegerProperty roomAddition;

    private final SimpleStringProperty guestName;
    private final SimpleIntegerProperty numberOfGuests;



    public ReservationList(
            int reservationId,
            String reservationNo,
            String guestName,
            int numberOfGuests,
            int status,
            String checkIn,
            String checkOut,
            String roomNumber,
            int roomAddition
    ) {
        this.reservationId = new SimpleIntegerProperty(reservationId);
        this.reservationNo = new SimpleStringProperty(reservationNo);
        this.guestName = new SimpleStringProperty(guestName);
        this.numberOfGuests = new SimpleIntegerProperty(numberOfGuests);
        this.status = new SimpleStringProperty(convertStatus(status));
        this.checkIn = new SimpleStringProperty(checkIn);
        this.checkOut = new SimpleStringProperty(checkOut);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.roomAddition = new SimpleIntegerProperty(roomAddition);

    }

    public int getReservationId() {
        return reservationId.get();
    }

    public String getReservationNo() {
        return reservationNo.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getCheckIn() {
        return checkIn.get();
    }

    public String getCheckOut() {
        return checkOut.get();
    }

    public String getRoomNumber() {
        return roomNumber.get();
    }

    public int getRoomAddition() {
        return roomAddition.get();
    }

    public String getGuestName() {
        return guestName.get();
    }

    public int getNumberOfGuests() {
        return numberOfGuests.get();
    }



    // setter
    public void setReservationId(int reservationId) {
        this.reservationId.set(reservationId);
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo.set(reservationNo);
    }

    public void setStatus(int status) {
        this.status.set(convertStatus(status));
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn.set(checkIn.toString());
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut.set(checkOut.toString());
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber.set(roomNumber);
    }

    public void setRoomAddition(int roomAddition) {
        this.roomAddition.set(roomAddition);
    }

    public void setGuestName(String guestName) {
        this.guestName.set(guestName);
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests.set(numberOfGuests);
    }


    //

    //method
    static String convertStatus(int status) {
        String answer;
        switch (status) {
            case CANCEL:
                answer = "Cancel";
                break;
            case UNCONFIRMED:
                answer = "Unconfirmed";
                break;
            case CONFIRMED:
                answer = "Confirmed";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
        return answer;
    }

}
