package group1.stayella.Controller;

import group1.stayella.Model.Charge;
import group1.stayella.Model.HotelFacility.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ControllerCharges extends ApplicationController {
    private List<HotelFacility> hotelFacilities;
    private Gym gym = new Gym(15, 100, 999999);
    private ExtraBed extraBed = new ExtraBed(10, 100, 50);
    private Parking parking = new Parking(10, 100, 50);
    private StoreLuggage storeLuggage = new StoreLuggage(10, 100, 50);
    private WashingRoom washingRoom = new WashingRoom(10, 100, 50);
    private FoodService foodService = new FoodService(10, 100, 50);

    private double chargeTotal;
    private Charge charge;

    @FXML
    private CheckBox[] checkBoxes;
    @FXML
    public CheckBox gymCheck;
    @FXML
    public CheckBox luggageCheck;
    @FXML
    public CheckBox extraBedCheck;
    @FXML
    public CheckBox foodServiceCheck;
    @FXML
    public CheckBox parkingCheck;
    @FXML
    public CheckBox washingRoomCheck;
    @FXML
    public CheckBox disabilityCheck;
    @FXML
    public Label sumOfCharge;
    @FXML
    public Button reset;
    @FXML
    public Button submit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chargeTotal = 0;
        hotelFacilities = getHotel().getFacilities();
        checkBoxes = new CheckBox[]{gymCheck, luggageCheck, extraBedCheck, foodServiceCheck, parkingCheck, washingRoomCheck};
        setClassToId();
    }


    private HotelFacility checkPairOfId(CheckBox id) {
        HotelFacility pair;
        switch (id.getId()) {
            case "gymCheck":
                pair = gym;
                break;
            case "extraBedCheck":
                pair = extraBed;
                break;
            case "luggageCheck":
                pair = storeLuggage;
                break;
            case "foodServiceCheck":
                pair = foodService;
                break;
            case "parkingCheck":
                pair = parking;
                break;
            case "washingRoomCheck":
                pair = washingRoom;
                break;
            default:
                pair = null;
        }
        return pair;
    }


    @FXML
    public void onResetAction() {
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                checkBoxes[i].setSelected(false);
            }
        }
        chargeTotal = 0;
        reflectSumOfCharge();
    }

    @FXML
    public void onCloseAction(ActionEvent actionEvent) {
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        Window window = scene.getWindow();
        window.hide();  //→ Closeする
    }

    @FXML
    public void onSubmitAction(ActionEvent actionEvent) {
        leadSceneAndSendData();
        onCloseAction(actionEvent);
    }

    private void leadSceneAndSendData() {
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/group1/stayella/View/ReservationView/index.fxml"));
            Parent root = loader.load();

            //Get next controller
            ReservationController reservationController = loader.getController();
            // Pass data
//            reservationController.transferMessage(reflectSumOfCharge());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onSelectedAction(ActionEvent actionEvent) {
        CheckBox checkBox = (CheckBox) actionEvent.getSource();
        double price = checkPairOfId(checkBox).getPrice();
        if (checkBox.isSelected()) {
            this.chargeTotal += price;
        } else {
            this.chargeTotal -= price;
        }
        reflectSumOfCharge();
    }

    private void reflectSumOfCharge() {
        sumOfCharge.setText("Total : $ " + Double.toString(chargeTotal));
    }

    private void setClassToId() {
        for (CheckBox id : checkBoxes
        ) {
            HotelFacility pair = checkPairOfId(id);
            id.setText(pair.getLabel() + "  $" + Double.toString(pair.getPrice()));
        }
    }


}
