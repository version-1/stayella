package group1.stayella.View.ChargesView;

import group1.stayella.Model.Charges;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ScreenCharges {
    public ScreenCharges() {
    }
    @FXML
    public static Button btn0 = new Button("Pet: $30");
    @FXML
    public static Button btn1 = new Button("Gym access: $20");
    @FXML
    public static Button btn2 = new Button("Store the luggage: $10");
    @FXML
    public static Button btn3 = new Button("Food amenities: $10");
    @FXML
    public static Button btn4 = new Button("Extra bed: $25");
    @FXML
    public static Button btn5 = new Button("Access to washing room: $10");
    public static Button btn6 = new Button("Parking: $30");
    public static Label price = new Label();
    public static Label parking = new Label();
    public static Label pet = new Label();
    public static Label gymAccess = new Label();
    public static Label luggage = new Label();
    public static Label food = new Label();
    public static Label extraBed = new Label();
    public static Label washingRoom = new Label();
    public static Charges charges;
    public static Button[] buttons;
    public static Label[] charge;


    public static void display(String title, String message) {
        buttons = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6};
        charges = new Charges();
        charge = new Label[]{price, pet, gymAccess, luggage, food, extraBed, washingRoom, parking};
        charges.markedCharges(buttons);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        VBox layout = new VBox(15);
        Label messageLabel = new Label();
        messageLabel.setText(message);
        messageLabel.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");

        //Button addButton = new Button();
        //addButton.setText("ADD CHARGES");
        //addButton.setOnAction(e -> window.close());


        layout.getChildren().add(messageLabel);
        layout.getChildren().addAll(buttons);
        //layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout, 400, 600);
        scene.getStylesheets().add("sample/View/css/popup.css");
        window.setScene(scene);
        window.showAndWait();
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
}
