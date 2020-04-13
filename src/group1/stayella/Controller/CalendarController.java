package group1.stayella.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import group1.stayella.Model.Room;
import group1.stayella.Model.Vacancy;
import group1.stayella.Resources.Images.Icon;
import group1.stayella.View.CalendarView.Calendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class CalendarController extends ApplicationController {
    @FXML
    TableView<Room> table;

    @FXML
    Label currentDate;

    @FXML
    Button edit;

    private Calendar calendar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calendar = new Calendar();
        initTable();

        ImageView image = Icon.getWithLayout(Icon.EDIT, 32, 32);
        edit.setGraphic(image);
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

        calendar.buildVacanciesTable(table, getCellFactory());

        for (Room room : getRooms()) {
            this.table.getItems().add(room);
        }
    }

    private Callback<TableColumn<Room, HashMap<String, Vacancy>>, TableCell<Room, HashMap<String, Vacancy>>> getCellFactory() {
        return col -> {
            String key = (String) col.getUserData();
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    HashMap<String, Vacancy> map = (HashMap<String, Vacancy>) item;
                    if (map != null) {
                        Vacancy v = map.get(key);
                        if (v == null) {
                          getStyleClass().add("closed-cell");
                        } else {
                          decorateCell(this, v);
                        }
                    }

                }
            };
        };
    }

    public void refreshCalendar() {
        this.table.getColumns().clear();
        this.table.getItems().clear();
        initTable();
    }

    @FXML
    public void refresh() {
        this.calendar = new Calendar();
        refreshCalendar();
    }

    @FXML
    public void next() {
        calendar.tomorrow();
        refreshCalendar();
    }

    @FXML
    public void previous() {
        calendar.yesterday();
        refreshCalendar();
    }

    @FXML
    public void onClickNewRervation(ActionEvent event) throws IOException {
        Callback<Class<?>, Object> factory = c -> {
            try {
                ReservationController controller = (ReservationController) c.newInstance();
                controller.setHotel(getHotel());
                controller.setSceneStack(getSceneStack());
                controller.setOnClose(e -> {
                    refreshCalendar();
                    return null;
                });
                return controller;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        };
        popUpAs(event, factory, "/ReservationView/index.fxml", 650, 770);
    }

    public void onClickCell(ActionEvent event, Vacancy vacancy) throws IOException {
        if (vacancy.isAvailable()) {
            return;
        }

        Callback<Class<?>, Object> factory = c -> {
            try {
                ReservationController controller = (ReservationController) c.newInstance();
                controller.setHotel(getHotel());
                controller.setReservation(vacancy.getReservation());
                controller.setSceneStack(getSceneStack());
                controller.setOnClose(e -> {
                    refreshCalendar();
                    return null;
                });
                return controller;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        };
        popUpAs(event, factory, "/ReservationView/index.fxml", 700, 800);
    }

    private void decorateCell(TableCell cell, Vacancy v) {
        cell.getStyleClass().add(Calendar.getCellStyleClass(v));
        if (v.isAvailable()) {
            return;
        }

        String buttonText = "";
        if (v.isFirstVacantForRervation()) {
            Color labelColor = Color.WHITE;
            if (v.isOccupied()) {
               labelColor = Color.web("#FFB800");
            }

            if (v.isCheckIn()) {
               labelColor = Color.web("#3AC72E");
            }

            if (v.isCheckOut()) {
               labelColor = Color.web("#404E4D");
            }
            BorderStroke stroke = new BorderStroke(
                null,
                null,
                null,
                labelColor,
                null,
                null,
                null,
                BorderStrokeStyle.SOLID,
                null,
                new BorderWidths(5),
                null
            );
            cell.setBorder(new Border(stroke));
            buttonText = v.getReservationText();
        }
        cell.setId(v.getReservationNo());
        Button btn = new Button(buttonText);
        btn.getStyleClass().add("button-cell");
        btn.setOnAction(e -> {
              try {
                  onClickCell(e, v);
              } catch (IOException e1) {
                  e1.printStackTrace();
              }
        });
        cell.setGraphic(btn);
    }
}
