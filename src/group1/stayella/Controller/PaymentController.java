package group1.stayella.Controller;

import group1.stayella.Model.CreditCard;
import group1.stayella.View.Paymentview.PopPayment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController extends ApplicationController {

    private CreditCard creditCard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PopPayment.display("Insert CC Info");
    }

    @FXML
    public void passData(ActionEvent actionEvent) {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("/group1/stayella/View/ReservationView/index.fxml"));
            //Parent root = (Parent) loader.load();
            //ReservationController reservationController = loader.getController();
            //reservationController.showCCInfo(cardNumber.getText());
            //PopPayment.display("Insert CC Info");
            //Stage thisStage = (Stage) ok.getScene().getWindow();
            //thisStage.close();
    }
}
