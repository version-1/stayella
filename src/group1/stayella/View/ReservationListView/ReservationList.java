package group1.stayella.View.ReservationListView;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sun.awt.XSettings;
import sun.tools.tree.Vset;

import java.time.LocalDate;

public class ReservationList {
    private final static int CANCEL = 0;
    private final static int UNCONFIRMED = 1;
    private final static int CONFIRMED = 2;


    private final SimpleStringProperty reservationNo;
    private final SimpleStringProperty status;
    private final SimpleStringProperty checkIn;
    private final SimpleStringProperty checkOut;
    private final SimpleStringProperty roomNumber;
    private final SimpleIntegerProperty roomAddition;

    private final SimpleStringProperty guestName;
    private final SimpleIntegerProperty numberOfGuests;
    private final SimpleStringProperty age;
    private final SimpleStringProperty language;
    private final SimpleStringProperty eMail;
    private final SimpleStringProperty phone;
//    private final SimpleStringProperty homeAddress;


    public ReservationList (
            String reservationNo,
            int status,
            LocalDate checkIn,
            LocalDate checkOut,
            String roomNumber,
            int roomAddition,
            String guestName,
            int numberOfGuests,
            String age,
            String language,
            String eMail,
            String phone
//            ,
//            String homeAddress
    ) {
        this.reservationNo = new SimpleStringProperty(reservationNo);
        this.status = new SimpleStringProperty(convertStatus(status));
        this.checkIn = new SimpleStringProperty(checkIn.toString());
        this.checkOut = new SimpleStringProperty(checkOut.toString());
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.roomAddition = new SimpleIntegerProperty(roomAddition);

        this.guestName = new SimpleStringProperty(guestName);
        this.numberOfGuests = new SimpleIntegerProperty(numberOfGuests);
        this.age = new SimpleStringProperty(age);
        this.language = new SimpleStringProperty(language);
        this.eMail = new SimpleStringProperty(eMail);
        this.phone = new SimpleStringProperty(phone);
//        this.homeAddress = new SimpleStringProperty(homeAddress);
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

    public String getAge() {
        return age.get();
    }

    public String getLanguage() {
        return language.get();
    }

    public String getEMail() {
        return eMail.get();
    }

    public String getPhone() {
        return phone.get();
    }

//    public String getHomeAddress() {
//        return homeAddress.get();
//    }

    // setter


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

    public void setAge(String age) {
        this.age.set(age);
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public void setEMail(String eMail) {
        this.eMail.set(eMail);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

//    public void setHomeAddress(String homeAddress) {
//        this.homeAddress.set(homeAddress);
//    }

    //

    //method
    static String convertStatus(int status) {
        String answer;
        switch(status) {
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
