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

        TableColumn<Room, ?> col1 = new TableColumn<>("Room No");
        col1.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        calendar.getColumns().add(col1);

        for (Room room : getRooms()) {
            calendar.getItems().add(room);
        }
    }
}
