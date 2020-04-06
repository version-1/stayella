package group1.stayella.View.Paymentview;

import group1.stayella.Controller.ApplicationController;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PopPayment extends ApplicationController implements Initializable {
    static ArrayList<String> creditCard;

    public static ArrayList<String> display(String title) {
        TextField fieldCardNumber = new TextField();
        TextField fieldCardHolderName = new TextField();
        TextField fieldSecurityCode = new TextField();
        Button submit = new Button();
        fieldCardNumber.setPromptText("Enter CC Number");
        fieldCardNumber.setMaxWidth(220);
        fieldCardHolderName.setPromptText("Enter CC Holder Name");
        fieldCardHolderName.setPrefWidth(220);
        fieldSecurityCode.setPromptText("Enter CVV");
        fieldSecurityCode.setPrefWidth(80);
        submit.setText("SUBMIT");
        submit.setPrefWidth(90);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(fieldSecurityCode, submit);
        hbox.setSpacing(50);
        GridPane gridPane = new GridPane();
        gridPane.add(fieldCardNumber, 1, 1, 3, 1);
        gridPane.add(fieldCardHolderName, 1, 3, 1, 1);
        gridPane.add(hbox, 1, 4, 3, 1);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        submit.setOnAction(e ->  {
            if (fieldCardNumber.getText().length() == 12 && fieldSecurityCode.getText() .length() == 3 && !fieldCardHolderName.getText().isEmpty()) {
            creditCard = new ArrayList<>(3);
            creditCard.add(0, fieldCardNumber.getText());
            creditCard.add(1, fieldCardHolderName.getText());
            creditCard.add(2, fieldSecurityCode.getText());
                window.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Invalid Credit Card Information!");
                alert.showAndWait();
            }
        });
        VBox layout = new VBox(5);
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");

        layout.getChildren().add(messageLabel);
        layout.getChildren().add(gridPane);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 220, 110);
        scene.getStylesheets().add("/group1/stayella/View/css/popup.css");
        window.setScene(scene);
        window.showAndWait();
        return creditCard;
    }
}
