package group1.stayella.Controller;


import group1.stayella.Model.Guest;
import group1.stayella.Model.Reservation;
import group1.stayella.Model.Room;
import group1.stayella.Model.Vacancy;
import group1.stayella.View.ReservationListView.ReservationList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import group1.stayella.Resources.Images.Icon;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationListController extends ApplicationController {
    @FXML
    public Label title;
    @FXML
    public Button edit;
    @FXML
    public TableView table;
    @FXML
    public Button back;


    private ObservableList<ReservationList> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.data = FXCollections.observableArrayList();
        setDataList();
        setTable();
    }

    public void setTable() {
        this.table.setEditable(false);

        table.setRowFactory(tv -> {
            TableRow<ReservationList> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    String reservationNo = row.getItem().getReservationNo();
                    System.out.println(reservationNo);
                }
            });
            return row ;
        });


        TableColumn<Reservation, String> reservationNoCol = new TableColumn<>("Reservation No.");
        TableColumn<Guest, String> guestNameCol = new TableColumn<>("Guest Name");
        TableColumn<Reservation, Integer> numberOfGuestsCol = new TableColumn<>("Number Of Guests");
        TableColumn<Reservation, String> statusCol = new TableColumn<>("Status");
        TableColumn<Reservation, String> checkInCol = new TableColumn<>("Check In");
        TableColumn<Reservation, String> checkOutCol = new TableColumn<>("Check Out");
        TableColumn<Reservation, String> roomNumberCol = new TableColumn<>("Room Number");
        TableColumn<Reservation, Integer> roomAdditionCol = new TableColumn<>("Room Addition");

        table.getColumns().addAll(reservationNoCol, guestNameCol, numberOfGuestsCol, statusCol, checkInCol, checkOutCol, roomNumberCol, roomAdditionCol);

        this.table.itemsProperty().setValue(data);
        this.table.setItems(data);
        reservationNoCol.setCellValueFactory(new PropertyValueFactory<>("reservationNo"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        checkInCol.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOutCol.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomAdditionCol.setCellValueFactory(new PropertyValueFactory<>("roomAddition"));
        guestNameCol.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        numberOfGuestsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfGuests"));

    }

    // make list
    private boolean checkSameReservation(int reservationId, ObservableList<ReservationList> data) {
        boolean answer = true;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getReservationId() == reservationId) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    private void setDataList() {
        for (int i = 0; i < getHotel().getRooms().size(); i++) {
            Room room = getHotel().getRooms().get(i);

            for (int k = 0; k < room.getVacancies().size(); k++) {
                Reservation reservation = room.getVacancies().get(k).getReservation();
                if (reservation != null) {
                    int reservationId = reservation.getId();
                    String reservationNo = reservation.getReservationNo();
                    String guestName = reservation.getMainGuest().getName();
                    int numberOfGuests = reservation.getNumberOfGuest();
                    int status = reservation.getStatus();
//                    String checkIn = reservation.getCheckOutTime().toString();
//                    String checkOut = reservation.getCheckInTime().toString();

                    String checkIn = "Check In";
                    String checkOut = "Check Out";

                    String roomNumber = room.getRoomNumber();
                    int roomAddition = reservation.getCharges().size();

                    ReservationList list = new ReservationList(
                            reservationId,
                            reservationNo,
                            guestName,
                            numberOfGuests,
                            status,
                            checkIn,
                            checkOut,
                            roomNumber,
                            roomAddition
                    );

                    System.out.println(
                            room.getID() + " " +
                            room.getNumberOfBeds()+ " " +
                            reservationNo+ " " +
                            guestName+ " " +
                            numberOfGuests+ " " +
                            status+ " " +
                            checkIn+ " " +
                            checkOut+ " " +
                            roomNumber+ " " +
                            roomAddition

                    );


                    if (checkSameReservation(reservationId, data)) {
                        data.add(list);
                    }
                }
            }

        }
    }

    @FXML
    public void transitToHome(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "index.fxml", 500, 500);
    }


    @FXML
    public void transitToReservationList(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "ReservationListView/index.fxml", 800, 600);
    }

}