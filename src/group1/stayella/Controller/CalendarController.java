package group1.stayella.Controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import group1.stayella.Model.Room;
import group1.stayella.Model.Vacancy;
import group1.stayella.Resources.Images.Icon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CalendarController extends ApplicationController {
    @FXML
    TableView<Room> calendar;

    @FXML
    Label currentDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        currentDate.setText(Vacancy.getDateString(new Date(), Vacancy.CALENDAR_DATE_FORMAT));
    }

    private void initTable() {

        TableColumn<Room, ?> col1 = new TableColumn<>("Room");
        col1.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        TableColumn<Room, ImageView> col2 = new TableColumn<Room, ImageView>();
        ImageView dollar = Icon.getWithLayout(Icon.DOLLAR, 15, 27);
        col2.setGraphic(dollar);
        col2.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));

        TableColumn<Room, ?> col3 = new TableColumn<>();
        ImageView people = Icon.getWithLayout(Icon.PEOPLE, 29, 21);
        col3.setGraphic(people);
        col3.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));

        TableColumn<Room, ?> col4 = new TableColumn<>();
        ImageView cigarette = Icon.getWithLayout(Icon.CIGARETTE, 29, 23);
        col4.setGraphic(cigarette);

        TableColumn<Room, ?> col5 = new TableColumn<>();
        ImageView pet = Icon.getWithLayout(Icon.PET, 24, 22);
        col5.setGraphic(pet);

        TableColumn<Room, ?> col6 = new TableColumn<>();
        ImageView clean = Icon.getWithLayout(Icon.CLEAN, 30, 23);
        col6.setGraphic(clean);

        calendar.getColumns().add(col1);
        calendar.getColumns().add(col2);
        calendar.getColumns().add(col3);
        calendar.getColumns().add(col4);
        calendar.getColumns().add(col5);
        calendar.getColumns().add(col6);

        for (Room room : getRooms()) {
            calendar.getItems().add(room);
        }
    }
}
