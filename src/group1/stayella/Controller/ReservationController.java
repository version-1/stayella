package group1.stayella.Controller;

import group1.stayella.Model.Charge;
import group1.stayella.Model.CreditCard;
import group1.stayella.Vallidation.NumberTextField;
import group1.stayella.Vallidation.TextTextField;
import group1.stayella.View.Paymentview.PopPayment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationController extends ApplicationController {

    @FXML
    Image image;
    @FXML
    ImageView imageView = new ImageView();

    @FXML
    Button buttonEdit = new Button();
    @FXML
    Image imageEdit;
    @FXML
    ImageView imageEditView = new ImageView();

    @FXML
    Button buttonCard = new Button();
    @FXML
    Label cardNumberLabel;
    @FXML
    Image imageCard;
    @FXML
    ImageView imageCardView = new ImageView();

    @FXML
    Button buttonAdditions = new Button();
    @FXML
    Image imageAdditions;
    @FXML
    ImageView imageAdditionsView = new ImageView();

    @FXML
    Button confirmed;
    @FXML
    Button unconfirmed;
    @FXML
    Button checkIn;
    @FXML
    Button checkOut;
    @FXML
    Button cancel;
    @FXML
    Button reservation;
    @FXML
    NumberTextField guestID;
    @FXML
    NumberTextField guestPhone;
    @FXML
    NumberTextField guestAge;
    @FXML
    TextTextField guestName;
    @FXML
    TextTextField guestEmail;

    private ArrayList<String> creditCardInfo;
    private CreditCard creditCard;

    private List<Charge> charges = new ArrayList<Charge>();

    @FXML
    public Label totalPrice;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTqWGB5YLwdAKCrHNiw9_I5jXeWHDlGHh83anl58WuJ4WwhzslJ&usqp=CAU");
        imageView.setImage(image);

        imageEdit = new Image("https://3aoh9sn3um-flywheel.netdna-ssl.com/wp-content/uploads/2017/01/edit-1-06-17-300x300.png");
        insertImage(imageEdit, imageEditView, buttonEdit, 25, 25);

        imageCard = new Image("https://www.nerdwallet.com/assets/blog/wp-content/uploads/2018/03/creditstacks.card_.front_.back-story-600x338.png");
        insertImage(imageCard, imageCardView, buttonCard, 240, 120);

        imageAdditions = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRz2AEfespdhCgKtTN2R-o6maiMq1_SuKR7q9drWDi6NGJqxkhQ&usqp=CAU");
        insertImage(imageAdditions, imageAdditionsView, buttonAdditions, 30, 30);

        confirmed.setOnAction(e -> {
            confirmed.isFocused();
            confirmed.setStyle("-fx-border-color: #00ee00; -fx-border-width: 3px;");
            unconfirmed.setStyle("-fx-border-color: #ee0000; -fx-border-width: 1px;");
        });

        unconfirmed.setOnAction(e -> {
            unconfirmed.isFocused();
            unconfirmed.setStyle("-fx-border-color: #00ee00; -fx-border-width: 3px;");
            confirmed.setStyle("-fx-border-color: #ee0000; -fx-border-width: 1px;");
        });

        buttonCard.setOnAction(e -> {
            creditCardInfo = PopPayment.display("Insert CC Info");
            if (creditCardInfo != null && creditCardInfo.size() == 3) {
                setCreditCard(creditCardInfo.get(0), creditCardInfo.get(1), creditCardInfo.get(2));
            }
            showCCInfo(creditCardInfo.get(0));
        });
    }

    public void showCCInfo(String text) {
        if (text.length() != 12) {
            this.cardNumberLabel.setText("INVALID!");
        }
        this.cardNumberLabel.setText("XXXX-XXXX-" + text.substring(8));
    }

    public void submit(ActionEvent event) {
        String message = "";
        if (!guestName.nameValidation(guestName.getText())) {
            message += "Invalid Guest's Name\n";
        } else if (!guestID.idNumberValidation(guestID.getText())) {
            message += "Invalid Guest's ID Number!\n";
        } else if (!guestAge.ageValidation(guestAge.getText())) {
            message += "Invalid Guest's Age\n";
        } else if (!guestEmail.emailValidation(guestEmail.getText())) {
            message += "Invalid Guest's Email";
        } else if (!guestPhone.phoneNumberValidation(guestPhone.getText())) {
            message += "Invalid Guest's Phone Number\n";
        } else if (!guestEmail.emailValidation(guestEmail.getText())) {
            message += "Invalid Guest's Email";
        }
        if (!message.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unconfirmed");
            alert.setHeaderText("Important information is missing.");
            alert.setContentText(message);
            alert.showAndWait();
        }
    }

    public void insertImage(Image image, ImageView imageView, Button button, int height, int width) {
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
    }

    public void openNewStage(ActionEvent actionEvent) {
        try {
            FXMLLoader loaderPayment = new FXMLLoader(getClass().getResource("/group1/stayella/View/Paymentview/index.fxml"));
            Parent rootPayment = loaderPayment.load();
            FXMLLoader loaderAdditions = new FXMLLoader(getClass().getResource("/group1/stayella/View/ChargesView/index.fxml"));
            Parent rootAdditions = loaderAdditions.load();
            Stage stage = new Stage();
            if (actionEvent.getSource() == buttonAdditions) {
                stage.setScene(new Scene(rootAdditions, 300, 400));
            } else if (actionEvent.getSource() == buttonCard) {
                //stage.setScene(new Scene(rootPayment, 280, 140));
            }
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void popupAsCharge(ActionEvent actionEvent) throws IOException {
        popUpAs(actionEvent,"ChargesView/index.fxml",330,400);
    }
      
    public void setCreditCard(String cardNumber, String name, String cvv) {
        creditCard = new CreditCard(0,0, cardNumber, name, null, cvv, null);
   
    }


    public void setCharges(List<Charge> charges){
        this.charges = charges;
        for (Charge charge: this.charges
             ) {
        }

    }

    public void setTotalPriceToLabel() {
        double total = 0;
        if(!charges.isEmpty()) {
            for (Charge charge : charges
            ) {
                System.out.println(charge.getFacility().getLabel());
                total += charge.getFacility().getPrice();
            }
        }
        System.out.println("[$] " + Double.toString(total));
        totalPrice.setText("[$] " + Double.toString(total));
    }
}
