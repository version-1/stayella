package group1.stayella.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Hotel> hotels = Factory.initialize();
        setHotel(hotels.get(0));

        label.setText("STAYELLA\nVersion: 1.0");
    }

    @FXML
    public void transitToReservaiton(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "ReservationView/index.fxml", 690, 800);
    }

    @FXML
    public void transitToCalendar(ActionEvent actionEvent) throws IOException {
        Stage stage = transitTo(actionEvent, "CalendarView/index.fxml", 800, 600);
        Scene scene = stage.getScene();
        scene.getStylesheets().add("group1/stayella/View/css/calendar/style.css");
    }

}
