package group1.stayella.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import group1.stayella.Model.Hotel;
import group1.stayella.Model.CSV.Factory;

public class HomeController extends ApplicationController {
    @FXML
    public Button reservation;
    @FXML
    public Button calendar;
    @FXML
    public Label label;
    @FXML
    public Button roomAdd;
    public Button reservationList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Hotel> hotels = Factory.initialize();
        setHotel(hotels.get(0));

        label.setText("STAYELLA\nVersion: 1.0");
    }

    @FXML
    public void transitToReservation(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "ReservationView/index.fxml", 650, 790);
    }

    @FXML
    public void transitToCalendar(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "CalendarView/index.fxml", 1200, 980);
    }

    @FXML
    public void transitToReservationList(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "ReservationListView/index.fxml", 800, 600);
    }


}
