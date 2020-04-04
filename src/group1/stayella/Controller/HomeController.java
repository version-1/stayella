package group1.stayella.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    }
}
