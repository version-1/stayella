package group1.stayella.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import group1.stayella.Model.Room;
import group1.stayella.Resources.Images.Icon;
import group1.stayella.View.CalendarView.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class CalendarController extends ApplicationController {
    @FXML
    TableView<Room> table;

    @FXML
    Label currentDate;

    private Calendar calendar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calendar = new Calendar();
        initTable();
    }

    private void initTable() {
        currentDate.setText(calendar.getDateString());

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

        TableColumn<Room, ImageView> col4 = new TableColumn<Room, ImageView>();
        col4.setCellValueFactory(new PropertyValueFactory<>("smorking"));
        ImageView cigarette = Icon.getWithLayout(Icon.CIGARETTE, 29, 23);
        col4.setGraphic(cigarette);

        TableColumn<Room, ImageView> col5 = new TableColumn<>();
        col5.setCellValueFactory(new PropertyValueFactory<>("pet"));
        ImageView pet = Icon.getWithLayout(Icon.PET, 24, 22);
        col5.setGraphic(pet);

        TableColumn<Room, ImageView> col6 = new TableColumn<>();
        col6.setCellValueFactory(new PropertyValueFactory<>("clean"));
        ImageView clean = Icon.getWithLayout(Icon.CLEAN, 30, 23);
        col6.setGraphic(clean);


        this.table.getColumns().add(col1);
        this.table.getColumns().add(col2);
        this.table.getColumns().add(col3);
        this.table.getColumns().add(col4);
        this.table.getColumns().add(col5);
        this.table.getColumns().add(col6);

        calendar.buildVacanciesTable(table);

        for (Room room: getRooms()) {
            this.table.getItems().add(room);
        }
    }

    @FXML
    public void refresh() {
        this.calendar = new Calendar();
        this.table.getColumns().clear();
        initTable();
    }

    @FXML
    public void next() {
        calendar.tomorrow();
        this.table.getColumns().clear();
        initTable();
    }

    @FXML
    public void previous() {
        calendar.yesterday();
        this.table.getColumns().clear();
        initTable();
    }
}
