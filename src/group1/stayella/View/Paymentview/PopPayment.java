package group1.stayella.View.Paymentview;

import group1.stayella.Controller.ApplicationController;
import group1.stayella.Vallidation.NumberTextField;
import group1.stayella.Vallidation.TextTextField;
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
        NumberTextField fieldCardNumber = new NumberTextField();
        TextTextField fieldCardHolderName = new TextTextField();
        NumberTextField fieldSecurityCode = new NumberTextField();
        NumberTextField fieldExpirationDate = new NumberTextField();
        Button submit = new Button();
        fieldCardNumber.setPromptText("Enter Card Number");
        fieldCardNumber.setMaxWidth(220);
        fieldCardHolderName.setPromptText("Enter Card Holder Name");
        fieldCardHolderName.setPrefWidth(220);
        fieldSecurityCode.setPromptText("CVV");
        fieldSecurityCode.setPrefWidth(70);
        fieldExpirationDate.setPromptText("MMYY");
        fieldExpirationDate.setPrefWidth(70);
        submit.setText("SUBMIT");
        submit.setPrefWidth(70);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(fieldSecurityCode,fieldExpirationDate, submit);
        hbox.setSpacing(5);
        GridPane gridPane = new GridPane();
        gridPane.add(fieldCardNumber, 1, 1, 3, 1);
        gridPane.add(fieldCardHolderName, 1, 3, 1, 1);
        gridPane.add(hbox, 1, 4, 3, 1);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        submit.setOnAction(e ->  {
            String message = "";
            if (!fieldCardNumber.cardNumberValidation(fieldCardNumber.getText())) {
                message += "Invalid Card Number!\n";
            } else if (!fieldCardHolderName.nameValidation(fieldCardHolderName.getText())) {
                message += "Invalid Card Holder Name!\n";
            } else if (!fieldSecurityCode.securityCodeValidation(fieldSecurityCode.getText())) {
                message += "Invalid Security code!\n";
            } else if (!fieldExpirationDate.expirationDateValidation(fieldExpirationDate.getText())) {
                message += "Invalid Expiration Date!\n";
            }
            if (message != "") {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Invalid Credit Card Information!");
                alert.setContentText(message);
                alert.showAndWait();
            } else {
                creditCard = new ArrayList<>();
                creditCard.add(0, fieldCardNumber.getText());
                creditCard.add(1, fieldCardHolderName.getText());
                creditCard.add(2, fieldSecurityCode.getText());
                creditCard.add(3, fieldExpirationDate.getText());
                window.close();
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
