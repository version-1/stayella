package group1.stayella.Controller;


import group1.stayella.Model.Charge;
import group1.stayella.Model.HotelFacility.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ControllerCharges extends ApplicationController {

    private List<Charge> chargesForReservation;
    private double chargeTotal;
    @FXML
    private GridPane container;

    @FXML
    private CheckBox[] checkBoxes;

    @FXML
    public Label sumOfCharge;
    public Label total;

    @FXML
    public Button reset;
    @FXML
    public Button submit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chargeTotal = 0;
        checkBoxes = new CheckBox[getHotel().getFacilities().size()];
        chargesForReservation = new ArrayList<Charge>();
        addFlowPane();
        reflectSumOfCharge();
    }



    private HotelFacility checkPairOfId(CheckBox checkBox) {
        for (HotelFacility facility: getHotel().getFacilities()
             ) {
            if(facility.getLabel() == checkBox.getText()) {
                return facility;
            }
        }
        return null;
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
    public void onSubmitAction(ActionEvent actionEvent) throws IOException {
        setFacilityToCharge(makeListForChecked());
        closeAction(actionEvent);
    }


    private void setFacilityToCharge(List<HotelFacility> hotelFacilitiesForReservation) {
        int id = 1;
        int reservationId = 111;
        for (HotelFacility facility: hotelFacilitiesForReservation
             ) {
            Charge charge = new Charge( id++, reservationId++, facility);
            chargesForReservation.add(charge);
        }
    }


    private List<HotelFacility> makeListForChecked(){
        List<HotelFacility> list = new ArrayList<>();
        for (int i = 0; i < checkBoxes.length; i++) {
            if(checkBoxes[i].isSelected()) {
                list.add(checkPairOfId(checkBoxes[i]));
            }
        }
        return list;
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
        sumOfCharge.setText("$ " + Double.toString(chargeTotal));
    }

    // flow pain
    public void  addFlowPane() {
        Integer row = 2;
        for(int i = 0; i < getHotel().getFacilities().size(); i++) {
            HotelFacility facility = getHotel().getFacilities().get(i);
            checkBoxes[i] = new CheckBox();
            checkBoxes[i].setId(facility.getKey());
            checkBoxes[i].setText(facility.getLabel());
            checkBoxes[i].setOnAction(this::onSelectedAction);
            container.add(checkBoxes[i], 1, row);
            Label label = new Label();
            label.setText("$ " + Double.toString(facility.getPrice()));
            container.add(label, 2, row++);
        }
    }

    public List<Charge> getChargesForReservation() {
        return chargesForReservation;
    }
}
