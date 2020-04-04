package group1.stayella.Controller;

import group1.stayella.Model.Charge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCharges extends ApplicationController {
    @FXML
    public Button btn0;
    @FXML
    public Button btn1;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    @FXML
    public Button btn5;
    @FXML
    public Button btn6;

    @FXML
    public Label price;
    @FXML
    public Label parking;
    @FXML
    public Label pet;
    @FXML
    public Label gymAccess;
    @FXML
    public Label luggage;
    @FXML
    public Label food;
    @FXML
    public Label extraBed;
    @FXML
    public Label washingRoom;

    private Charge charge;
    private Button[] buttons;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.buttons = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6};
        // charge = new Charge();
        // charges.markedCharges(buttons);
        // price.setText("Total: $" + charges.getChargesTotal());

        pet.setText("Pet: $30");
        gymAccess.setText("Gym access: $20");
        luggage.setText("Store the luggage: $10");
        food.setText("Food amenities: $10");
        extraBed.setText("Extra bed: $25");
        washingRoom.setText("Access to washing room: $10");
        parking.setText("Parking: $30");

    }

    @FXML
    public void markCharge(ActionEvent actionEvent) {
        Button btnClicked = (Button) actionEvent.getSource();
        if (btnClicked.getText().equals("")) {
            btnClicked.setText("✓");
        } else {
            btnClicked.setText("");
        }
        // charge.markedCharges(buttons);
        // price.setText("Total: $" + charge.getChargesTotal());
    }

    public void reset() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
        }
    }
}
