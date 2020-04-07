package group1.stayella.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import group1.stayella.Model.Room;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CalendarController extends ApplicationController {
    @FXML
    TableView<Room> calendar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }

    public void initTable() {

        TableColumn<Room, ?> col1 = new TableColumn<>("Room");
        col1.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        TableColumn<Room, ?> col2 = new TableColumn<>("Price");
        col2.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));

        TableColumn<Room, ?> col3 = new TableColumn<>("Capacity");
        col3.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));

        TableColumn<Room, ?> col4 = new TableColumn<>("Smoke");
        TableColumn<Room, ?> col5 = new TableColumn<>("Pet");
        TableColumn<Room, ?> col6 = new TableColumn<>("Status");
        // col3.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));

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
