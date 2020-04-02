package group1.stayella.Controller;

import group1.stayella.Model.Charges;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCharges implements Initializable {
    @FXML
    public static Button btn0;
    @FXML
    public static Button btn1;
    @FXML
    public static Button btn2;
    @FXML
    public static Button btn3;
    @FXML
    public static Button btn4;
    @FXML
    public static Button btn5;
    @FXML
    public static Button btn6;

    @FXML
    public static Label price;
    @FXML
    public static Label parking;
    @FXML
    public static Label pet;
    @FXML
    public static Label gymAccess;
    @FXML
    public static Label luggage;
    @FXML
    public static Label food;
    @FXML
    public Label extraBed;
    @FXML
    public Label washingRoom;

    private static Charges charges;
    private static Button[] buttons;


    public void initialize(URL location, ResourceBundle resources) {
        buttons = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6};
        charges = new Charges();
        charges.markedCharges(buttons);
        price.setText("Total: $" + charges.getChargesTotal());
    }

    @FXML
    public void markCharge(ActionEvent actionEvent) {
        Button btnClicked = (Button) actionEvent.getSource();
        if (btnClicked.getText().equals("")) {
            btnClicked.setText("✓");
        } else {
            btnClicked.setText("");
        }
        charges.markedCharges(buttons);
        price.setText("Total: $" + charges.getChargesTotal());
    }

    public void reset() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
        }
    }
}
