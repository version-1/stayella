package group1.stayella.Controller;


import group1.stayella.Model.Reservation;
import group1.stayella.Model.Room;
import group1.stayella.Model.Vacancy;
import group1.stayella.View.ReservationListView.ReservationList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationListController extends ApplicationController {
    @FXML
    public Label title;
    @FXML
    public Button reload;
    @FXML
    public TableView table;

    private ObservableList<ReservationList> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();
    }

    public void setTable() {
        table.setEditable(false);

        TableColumn reservationInfo = new TableColumn("Reservation");
        TableColumn guestInfo = new TableColumn("Guest Information");

        TableColumn reservationNoCol = new TableColumn("Reservation No.");
        TableColumn statusCol = new TableColumn("Status");
        TableColumn checkInCol = new TableColumn("Check In");
        TableColumn checkOutCol = new TableColumn("Check Out");
        TableColumn roomNumberCol = new TableColumn("Room Number");
        TableColumn roomAdditionCol = new TableColumn("Room Addition");

        TableColumn guestNameCol = new TableColumn("Guest Name");
        TableColumn numberOfGuestsCol = new TableColumn("Number Of Guests");
        TableColumn ageCol = new TableColumn("Age");
        TableColumn languageCol = new TableColumn("Language");
        TableColumn eMailCol = new TableColumn("E-mail");
        TableColumn phoneCol = new TableColumn("Phone");
        TableColumn homeAddressCol = new TableColumn("Home Address");


        reservationInfo.getColumns().addAll(reservationNoCol, statusCol, checkInCol, checkOutCol, roomNumberCol, roomAdditionCol);
        guestInfo.getColumns().addAll(guestNameCol, numberOfGuestsCol, ageCol, languageCol, eMailCol, phoneCol, homeAddressCol);

        table.getColumns().addAll(reservationInfo, guestInfo);


        setDataList();

//        reservationNoCol.setCellValueFactory(
//                new PropertyValueFactory<>("reservationNo")
//        );
//        statusCol.setCellValueFactory(
//                new PropertyValueFactory<>("status")
//        );
//        checkInCol.setCellValueFactory(
//                new PropertyValueFactory<>("checkIn")
//        );
    }

    // make list
    private int getNumberOfList() {
        ArrayList<Room> rooms = (ArrayList<Room>) getHotel().getRooms();
        int NumberOfRoom = rooms.size();
        int NumberOfVacancy = 0;
        for (int i = 0; i < NumberOfRoom; i++) {
            NumberOfVacancy += rooms.get(i).getVacancies().size();
        }
        return NumberOfVacancy;
    }

    private boolean checkSameReservation(Reservation reservation1, Reservation reservation2){
        if(reservation1.equals(reservation2)) {
            return false;
        } else {
            return true;
        }
    }

    private void setDataList() {
        for (int i = 0; i < getHotel().getRooms().size(); i++) {
            Room room = getHotel().getRooms().get(i);
            Reservation compared;
            for (int k = 0; k < room.getVacancies().size(); k++) {
                System.out.println("Room:" + i + ", vacancy: " + k);
                Reservation reservation = room.getVacancies().get(k).getReservation();
                if (reservation != null){
                    String reservationNo = reservation.getReservationNo();
                    int status = reservation.getStatus();
                    LocalDate checkIn = reservation.getCheckInTime();
                    LocalDate checkOut = reservation.getCheckOutTime();
                    String roomNumber = room.getRoomNumber();
                    int roomAddition = reservation.getCharges().size();
                    String guestName = reservation.getMainGuest().getName();
                    int numberOfGuests = reservation.getNumberOfGuest();
                    String age = reservation.getMainGuest().getAge();
                    String language = reservation.getMainGuest().getLanguage();
                    String eMail = reservation.getMainGuest().getEmailAddress();
                    String phone = reservation.getMainGuest().getPhoneNumber();
//                String homeAddress = reservation.getMainGuest().get
                    System.out.println(reservationNo+" " + status+" " +
                            checkIn+" " +
                            checkOut+" " +
                            roomNumber+" " +
                            roomAddition+" " +
                            guestName+" " +
                            numberOfGuests+" " +
                            age+" " +
                            language+" " +
                            eMail+" " + phone);
//                    data.add(
//                            new ReservationList(
//                                    reservationNo, status,
//                                    checkIn,
//                                    checkOut,
//                                    roomNumber,
//                                    roomAddition,
//                                    guestName,
//                                    numberOfGuests,
//                                    age,
//                                    language,
//                                    eMail, phone
//                            )
//                    );
                }
            }

        }
    }


}