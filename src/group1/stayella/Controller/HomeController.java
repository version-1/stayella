package group1.stayella.Controller;

import group1.stayella.Resources.Images.Icon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import group1.stayella.Model.Hotel;
import group1.stayella.Model.CSV.Factory;

public class HomeController extends ApplicationController {
    @FXML
    public Button calendar;
    @FXML
    public Button reservation;
    @FXML
    public Button reservationList;
    @FXML
    public Label title;
    @FXML
    public Label version;


    @FXML


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Hotel> hotels = Factory.initialize();
        setHotel(hotels.get(0));
        putImagesOnButton();
        title.setText("STAYELLA");
        version.setText("STAYELLA Version: 1.0");
    }

    @FXML
    private void putImagesOnButton() {
        javafx.scene.image.ImageView book = Icon.getWithLayout(Icon.CALENDAR_WHITE, 82, 94);
        calendar.setText("Calendar");
        calendar.setGraphic(book);
        calendar.setContentDisplay(ContentDisplay.TOP);
        calendar.setTextAlignment(TextAlignment.CENTER);

        javafx.scene.image.ImageView edit = Icon.getWithLayout(Icon.EDIT_WHITE, 56, 50);
        reservation.setText("New Booking ");
        reservation.setGraphic(edit);

        javafx.scene.image.ImageView listBook = Icon.getWithLayout(Icon.BOOK_WHITE, 56, 50);
        reservationList.setText("Booking List");
        reservationList.setGraphic(listBook);

    }


    @FXML
    public void transitToReservation(ActionEvent actionEvent) throws IOException {
        popUpAs(actionEvent, "ReservationView/index.fxml", 650, 790);
    }

    @FXML
    public void transitToCalendar(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "CalendarView/index.fxml", 1200, 980);
    }

    @FXML
    public void transitToReservationList(ActionEvent actionEvent) throws IOException {
        transitTo(actionEvent, "ReservationListView/index.fxml", 850, 600);
    }


}
