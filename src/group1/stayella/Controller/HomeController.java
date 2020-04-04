package group1.stayella.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Hotel> hotels = Factory.initialize();
        setHotel(hotels.get(0));

        label.setText("STAYELLA\nVersion: 1.0");
    }

    @FXML
    public void transitToReservaiton(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        URL url = getClass().getClassLoader().getResource("group1/stayella/View/ReservationView/index.fxml");
        Parent page = FXMLLoader.load(url);

        Scene newPage = new Scene(page, 500, 500);

        stage.setScene(newPage);
    }

    @FXML
    public void transitToCalendar(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "CalendarView/index.fxml");
    }
}
