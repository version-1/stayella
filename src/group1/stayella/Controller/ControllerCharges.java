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

    private List<Charge> chargesForReservation = new ArrayList<Charge>();
    private double chargeTotal;

    @FXML
    private GridPane container;
    @FXML
    private CheckBox[] checkBoxes;
    @FXML
    public Label sumOfCharge;
    @FXML
    public Label total;
    @FXML
    public Button reset;
    @FXML
    public Button submit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkBoxes = new CheckBox[getHotel().getFacilities().size()];
        addFlowPane();
        reflectSumOfCharge();
    }

    private HotelFacility checkPairOfId(CheckBox checkBox) {
        for (HotelFacility facility : getHotel().getFacilities()
        ) {
            if (facility.getLabel() == checkBox.getText()) {
                return facility;
            }
        }
        return null;
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
    @FXML
    public void addFlowPane() {
        Integer row = 2;
        for (int i = 0; i < getHotel().getFacilities().size(); i++) {
            HotelFacility facility = getHotel().getFacilities().get(i);
            checkBoxes[i] = new CheckBox();
            checkBoxes[i].setId(facility.getKey());
            checkBoxes[i].setText(facility.getLabel());
            checkBoxes[i].setOnAction(this::onSelectedAction);
            for (Charge reserveC : chargesForReservation
            ) {
                if (reserveC.getFacility() == facility) {
                    checkBoxes[i].setSelected(true);
                    break;
                }
            }
            container.add(checkBoxes[i], 1, row);
            Label label = new Label();
            label.setText("$ " + Double.toString(facility.getPrice()));
            container.add(label, 2, row++);
        }
    }

    public List<Charge> getChargesForReservation() {
        return chargesForReservation;
    }

    public void setChargesForReservation(List<Charge> chargesForReservation) {
        this.chargesForReservation = chargesForReservation;
    }


    @FXML
    public void onResetAction() {
        if (chargesForReservation.isEmpty()) {
            for (int i = 0; i < checkBoxes.length; i++) {
                if (checkBoxes[i].isSelected()) {
                    checkBoxes[i].setSelected(false);
                }
            }
            chargeTotal = 0;
        } else {
            for (int i = 0; i < checkBoxes.length; i++) {
                String boxLabel = checkBoxes[i].getText();
                double price = checkPairOfId(checkBoxes[i]).getPrice();
                boolean selected = checkBoxes[i].isSelected();
                int count = 0;
                for (int k = 0; k < chargesForReservation.size(); k++) {
                    String CFRLabel = chargesForReservation.get(k).getFacility().getLabel();
                    if (boxLabel == CFRLabel) {
                        count++;
                    }
                }
                if (count == 1 && !selected) {
                    checkBoxes[i].setSelected(true);
                    chargeTotal += price;
                } else if (count == 0 && selected) {
                    checkBoxes[i].setSelected(false);
                    chargeTotal -= price;
                }
            }
        }
        reflectSumOfCharge();
    }

    @FXML
    public void onSubmitAction(ActionEvent actionEvent) throws IOException {
        makeListForChecked();
        closeAction(actionEvent);
    }

    private void makeListForChecked() {
        chargesForReservation.clear();
        int id = 1;
        int reservationId = 111;
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                chargesForReservation.add(new Charge(id++, reservationId++, checkPairOfId(checkBoxes[i])));
            }
        }
    }



}
