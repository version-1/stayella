package group1.stayella.Controller;

import group1.stayella.View.ChargesView.ScreenCharges;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Screen;
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
//        window.initModality(Modality.APPLICATION_MODAL);
//        window.setTitle("Stayella");
        reservation.setText("Reservation");
        calendar.setText("Calendar");
        reservation.setOnAction(e -> ScreenCharges.display("Additions", "..."));
    }
}
