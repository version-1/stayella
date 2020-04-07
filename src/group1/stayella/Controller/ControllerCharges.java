package group1.stayella.Controller;


import group1.stayella.Model.Charge;
import group1.stayella.Model.HotelFacility.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    /** extra
     * 読み込めるようになったら消す
     *
     */
    private Gym gym = new Gym(15, 100, 999999);
    private ExtraBed extraBed = new ExtraBed(10, 100, 50);
    private Parking parking = new Parking(10, 100, 50);
    private StoreLuggage storeLuggage = new StoreLuggage(10, 100, 50);
    private WashingRoom washingRoom  = new WashingRoom(10, 100, 50);
    private FoodService foodService = new FoodService(10, 100, 50);
    private ArrayList<HotelFacility> hotelFacilities = new ArrayList<HotelFacility>();
    /** extra
     * ここまで
     *
     */

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
        addHotelFacilities(hotelFacilities);
        checkBoxes = new CheckBox[hotelFacilities.size()];
        chargesForReservation = new ArrayList<Charge>();
        addFlowPane();
        reflectSumOfCharge();
    }

    /** extra
     * 読み込めるようになったら消す
     * @param list
     */
    private void addHotelFacilities(ArrayList<HotelFacility> list){
        list.add(gym);
        list.add(extraBed);
        list.add(parking);
        list.add(storeLuggage);
        list.add(washingRoom);
        list.add(foodService);
    }

    private HotelFacility checkPairOfId(CheckBox checkBox) {
        for (HotelFacility facility: hotelFacilities
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
        setDataToReservation();
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

    private void setDataToReservation () throws IOException {
        URL url = getClass().getClassLoader().getResource("group1/stayella/View/ReservationView/index.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        ReservationController reservationController = loader.getController();
        reservationController.setCharges(getChargesForReservation());
        reservationController.setTotalPriceToLabel();
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
        for(int i = 0; i < hotelFacilities.size(); i++) {
            HotelFacility facility = hotelFacilities.get(i);
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
