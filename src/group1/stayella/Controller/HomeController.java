package group1.stayella.Controller;

import group1.stayella.View.ChargesView.ScreenCharges;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public Button reservation;
    @FXML
    public Button calendar;
    @FXML
    public Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("STAYELLA\nVersion: 1.0");

        reservation.setText("Reservation");
        reservation.setOnAction(e -> showReservation());

        calendar.setText("Calendar");
        calendar.setOnAction(e -> showCalender());
    }

    private void showReservation() {
        Stage window = new Stage();
        window.setTitle("Reservation");

        VBox layout = new VBox(15);
        Label messageLabel = new Label();
        messageLabel.setText("...");
        messageLabel.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");

        Button addButton = new Button();
        addButton.setText("ADD CHARGES");
        layout.getChildren().add(messageLabel);
        layout.getChildren().add(addButton);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout, 200, 80);
        scene.getStylesheets().add("sample/View/css/popup.css");
        window.setScene(scene);
        window.showAndWait();
    }

    private void showCalender() {
        Stage window = new Stage();
        window.setTitle("Calender");

        VBox layout = new VBox(15);
        Label messageLabel = new Label();
        messageLabel.setText("...");
        messageLabel.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");

        Button addButton = new Button();
        addButton.setText("ADD CHARGES");
        layout.getChildren().add(messageLabel);
        layout.getChildren().add(addButton);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout, 200, 80);
        scene.getStylesheets().add("sample/View/css/popup.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
