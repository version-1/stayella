package group1.stayella.Controller;


import group1.stayella.Model.Guest;
import group1.stayella.Model.Reservation;
import group1.stayella.Model.Room;
import group1.stayella.Model.Vacancy;
import group1.stayella.Resources.Images.Icon;
import group1.stayella.View.ReservationListView.ReservationList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class ReservationListController extends ApplicationController {
    @FXML
    public Label title;

    @FXML
    public TableView table;
    @FXML
    public Button back;


    private ObservableList<ReservationList> data;

    private Reservation reservation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.data = FXCollections.observableArrayList();
        setDataList();
        setTable();
    }

    public void setTable() {
        table.setEditable(false);
        table.setItems(data);

        onMouseSetReservation(table);

        TableColumn<ReservationList, ReservationList> editCol = new TableColumn("Edit");
        editCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> reservationNoCol = new TableColumn<>("Reservation No.");
        reservationNoCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> guestNameCol = new TableColumn<>("Guest Name");
        guestNameCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> numberOfGuestsCol = new TableColumn<>("");
        numberOfGuestsCol.setPrefWidth(30);
        ImageView people = Icon.getWithLayout(Icon.PEOPLE, 18, 12);
        numberOfGuestsCol.setGraphic(people);
        numberOfGuestsCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> statusCol = new TableColumn<>("Status");
        statusCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> checkInCol = new TableColumn<>("Check In");
        checkInCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> checkOutCol = new TableColumn<>("Check Out");
        checkOutCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> roomNumberCol = new TableColumn<>("Room\nNumber");
        roomNumberCol.setStyle("-fx-alignment: center;");

        TableColumn<ReservationList, ReservationList> roomAdditionCol = new TableColumn<>("Room\nAddition");
        roomAdditionCol.setStyle("-fx-alignment: center;");

        table.getColumns().addAll(editCol, reservationNoCol, guestNameCol, numberOfGuestsCol, statusCol, checkInCol, checkOutCol, roomNumberCol, roomAdditionCol);

        this.table.itemsProperty().setValue(data);

        reservationNoCol.setCellValueFactory(new PropertyValueFactory<>("reservationNo"));
        guestNameCol.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        numberOfGuestsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfGuests"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        checkInCol.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOutCol.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomNumberCol.setStyle("-fx-alignment: center;");
        roomAdditionCol.setCellValueFactory(new PropertyValueFactory<>("roomAddition"));
        roomAdditionCol.setStyle("-fx-alignment: center;");


        editCol.setCellValueFactory(new PropertyValueFactory<>("reservationList"));
        editCol.setCellFactory(getCellFactory());
        editCol.setStyle("-fx-alignment: center;");

    }

    // make list


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

                    List<Vacancy> vacancies = reservation.getVacancies();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd EEE h:mm a");
                    String checkIn = formatter.format(vacancies.get(0).getStartTime());
                    String checkOut = formatter.format(vacancies.get(vacancies.size() - 1).getEndTime());

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
                            roomAddition,
                            reservation
                    );

                    if (!haveSameReservation(reservationId, data)) {
                        data.add(list);
                    }
                }
            }

        }
    }

    private boolean haveSameReservation(int reservationId, ObservableList<ReservationList> data) {
        boolean answer = false;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getReservationId() == reservationId) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    public void onClickCell(ActionEvent event, ReservationList selected) throws IOException {
        Callback<Class<?>, Object> factory = c -> {
            try {
                ReservationController controller = (ReservationController) c.newInstance();
                String roomNumber = selected.getRoomNumber();
                String reservationNo = selected.getReservationNo();
                controller.setReservation(selected.getReservation());
                controller.setHotel(getHotel());
                controller.setSceneStack(getSceneStack());
                return controller;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        };
        popUpAs(event, factory, "/ReservationView/index.fxml", 650, 790);

    }


    private void onMouseSetReservation(TableView table) {
        table.setRowFactory(tv -> {
            TableRow<ReservationList> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ReservationList reservationList = row.getItem();
//                    onClickCell(event, reservationList);

                }
            });
            return row;
        });
    }


    private Callback<TableColumn<ReservationList, ReservationList>, TableCell<ReservationList, ReservationList>> getCellFactory() {
        return col -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        Button button = new Button();
                        ImageView edit = Icon.getWithLayout(Icon.EDIT, 12, 12);
                        button.setGraphic(edit);
                        button.setText("Edit");
                        setText(null);
                        button.getStyleClass().add("button-edit");
                        button.setOnAction(event -> {
                            ReservationList value = (ReservationList)item;
                            try {
                                onClickCell(event, value);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        setGraphic(button);
                    }
                }
            };
        };
    }
}
