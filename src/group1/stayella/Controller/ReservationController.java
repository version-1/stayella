package group1.stayella.Controller;

import group1.stayella.Model.*;
import group1.stayella.Vallidation.NumberTextField;
import group1.stayella.Vallidation.TextTextField;
import group1.stayella.View.Paymentview.PopPayment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class ReservationController extends ApplicationController {

    @FXML
    public Button imageUpload;

    @FXML
    Image image;
    @FXML
    ImageView imageView = new ImageView();

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
    NumberTextField numberOfGuests;
    @FXML
    TextTextField guestName;
    @FXML
    TextTextField guestEmail;
    @FXML
    TextTextField guestLanguage;
    @FXML
    TextArea guestAddress;
    @FXML
    DatePicker checkIN;
    @FXML
    DatePicker checkOUT;

    @FXML
    ComboBox<String> categorySelection;
    @FXML
    ComboBox<String> roomSelection;

    private int id = 0;
    private ArrayList<String> creditCardInfo;
    private CreditCard creditCard;

    private List<Charge> charges = new ArrayList<>();
    private HashMap<String, Room> availableRooms = new HashMap<>();

    @FXML
    public Label totalPrice;
    @FXML
    Label deposit;

    private Guest guest;
    private Reservation newReservation;
    private int status = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] categories = {"CategoryA", "CategoryB", "CategoryC", "CategoryD"};
        categorySelection.getItems().addAll(categories);
        deposit.setText("[$] " + this.getHotel().getDeposit());

        image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTqWGB5YLwdAKCrHNiw9_I5jXeWHDlGHh83anl58WuJ4WwhzslJ&usqp=CAU");
        imageView.setImage(image);

        imageCard = new Image("https://www.nerdwallet.com/assets/blog/wp-content/uploads/2018/03/creditstacks.card_.front_.back-story-600x338.png");
        insertImage(imageCard, imageCardView, buttonCard, 280, 140);

        imageAdditions = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRz2AEfespdhCgKtTN2R-o6maiMq1_SuKR7q9drWDi6NGJqxkhQ&usqp=CAU");
        insertImage(imageAdditions, imageAdditionsView, buttonAdditions, 30, 30);

        confirmed.setOnAction(e -> {
            confirmed.isFocused();
            confirmed.setStyle("-fx-border-color: #00ee00; -fx-border-width: 3px;");
            unconfirmed.setStyle("-fx-border-color: #ee0000; -fx-border-width: 1px;");
            status = 2;
        });

        unconfirmed.setOnAction(e -> {
            unconfirmed.isFocused();
            unconfirmed.setStyle("-fx-border-color: #00ee00; -fx-border-width: 3px;");
            confirmed.setStyle("-fx-border-color: #ee0000; -fx-border-width: 1px;");
            status = 1;
        });

        buttonCard.setOnAction(e -> {
            creditCardInfo = PopPayment.display("Insert CC Info");
            if (creditCardInfo != null && creditCardInfo.size() > 3) {
                setCreditCard(creditCardInfo.get(0), creditCardInfo.get(1), creditCardInfo.get(2), creditCardInfo.get(3));
                showCCInfo(creditCardInfo.get(0));
            }
        });
    }

    /**
     **************** Room Methods ****************
     **/

    public void listOfAvailability(){
        availableRooms.clear();
        if (checkIN.getValue() == null || checkOUT.getValue() == null) {
            alertMessage("Not Allowed", "Important information is missing.", "Select [Check in - Check out] dates");
        } else {
            List<Room> rooms = this.getHotel().getRooms();
            List<Vacancy> vacancies = rooms.get(1).getVacancies();
            Date in = Date.from(checkIN.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date out = Date.from(checkOUT.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            for (int i = 0; i < rooms.size(); i++) {
                boolean occupied = false;
                for (int j = 0; j < rooms.get(i).getVacancies().size(); j++)
                    if (rooms.get(i).getVacancies().get(j).getEndTime().compareTo(in) < 0 ||
                            rooms.get(i).getVacancies().get(j).getStartTime().compareTo(out) > 0) {
                    } else {
                        occupied = true;
                    }
                if (!occupied) {
                    availableRooms.put(rooms.get(i).getRoomNumber(), rooms.get(i));
                }
            }
        }
    }

    @FXML
    public void categorySelected() {
        listOfAvailability();
        roomSelection.getItems().clear();
        if (numberOfGuests.getText().length() > 0) {
            for (Room room : availableRooms.values()) {
                if (categorySelection.getValue().equals("CategoryD") && room.getID() < 4 && Integer.parseInt(numberOfGuests.getText()) <= 2) {
                    roomSelection.getItems().add(room.getRoomNumber());
                } else if (categorySelection.getValue().equals("CategoryC") && room.getID() >= 4 &&
                        room.getID() < 10 && Integer.parseInt(numberOfGuests.getText()) <= 4) {
                    roomSelection.getItems().add(room.getRoomNumber());
                } else if (categorySelection.getValue().equals("CategoryB") && room.getID() >= 10 &&
                        room.getID() < 16 && Integer.parseInt(numberOfGuests.getText()) <= 6) {
                    roomSelection.getItems().add(room.getRoomNumber());
                } else if (categorySelection.getValue().equals("CategoryA") && room.getID() >= 16 &&
                        Integer.parseInt(numberOfGuests.getText()) <= 10) {
                    roomSelection.getItems().add(room.getRoomNumber());
                }
            }
        } else {
            alertMessage("Cannot proceed", "Important information is missing.", "Not define amount of guests.");
        }
    }

    /**
     **************** Payment Methods ****************
     **/

    public void showCCInfo(String text) {
        if (text.length() != 12) {
            this.cardNumberLabel.setText("INVALID!");
        }
        this.cardNumberLabel.setText("XXXX-XXXX-" + text.substring(8));
    }

    public void setCreditCard(String cardNumber, String name, String cvv, String expirationDate) {
        creditCard = new CreditCard(id, cardNumber, name, cvv, expirationDate);
        System.out.println(creditCard);
//        creditCard.setId(id);
//        creditCard.setCardNumber(cardNumber);
//        creditCard.setCardHolderName(name);
//        creditCard.setCardSecurityNumber(cvv);
//        creditCard.setExpired(expirationDate);
    }

    public void setTotalPriceToLabel() {
        double total = 0;
        if (roomSelection.getValue() != null && availableRooms.containsKey(roomSelection.getValue())) {
            total += availableRooms.get(roomSelection.getValue()).getRoomPrice();
        }
        if (!charges.isEmpty()) {
            for (Charge charge : charges) {
                total += charge.getFacility().getPrice();
            }
        }
        totalPrice.setText("[$] " + Double.toString(total));
    }

    /**
     **************** Reservation Methods ****************
     */

    public boolean submit() {
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
            message += "Invalid Guest's Email\n";
        } else if (checkIN.getValue() == null || checkOUT.getValue() == null) {
            message += "C/I and C/O dates are not set\n";
        } else if (!numberOfGuests.numberOfGuestValidation(numberOfGuests.getText())) {
            message += "Invalid number of guests\n";
        } else if (roomSelection.getValue() == null) {
            message += "Room is not selected\n";
        } else if (status == 0) {
            message += "Cannot be reserved with undefined status";
        }
        if (!message.equals("")) {
            alertMessage("Unconfirmed", "Important information is missing.", message);
            return false;
        }
        return true;
    }

    @FXML
    public void makeAReservation(ActionEvent actionEvent) {
        if (submit()) {
            Period period = Period.between(checkIN.getValue(), checkOUT.getValue());
            int lengthOfStay = (int) (period.getDays());

            newReservation = new Reservation(guest, Integer.parseInt(numberOfGuests.getText()), status);
            Room room = this.getHotel().getRooms().get(1);
            newReservation.make(room, checkIN.getValue(), lengthOfStay);
            if (newReservation.setCheckInTime(checkIN.getValue()) &&
                    newReservation.setCheckOutTime(checkOUT.getValue()) && setGuestInformation()) {
                newReservation.setCharges(charges);
                System.out.println("RESERVATION WAS CREATED\n" + newReservation);
                System.out.println(guest);
            } else {
                alertMessage("Unconfirmed", "Important information is missing",
                        "Reservation was not created, please check the dates and the payment method");
            }
        }
    }

    public boolean setGuestInformation() {
        guest = new Guest(id, guestName.getText(), guestAge.getText(), imageView.getImage(), guestPhone.getText(),
                guestEmail.getText(), guestID.getText(), creditCard, guestLanguage.getText());
        // guest's address should be added
        if (creditCard == null) {
            alertMessage("Unconfirmed", "This payment method cannot be confirmed",
                    "Nothing was submit");
            return false;
        }
        if (creditCard != null && !guest.nameCheck(creditCard.getCardHolderName())) {
            alertMessage("Unconfirmed", "This payment method cannot be confirmed",
                    "Cardholder name and guest name does not mach");
            return false;
        }
        guest.setPaymentMethod(creditCard);
        return true;
    }

    public void alertMessage(String tittle, String message, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(tittle);
        alert.setHeaderText(message);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     **************** Room Methods ****************
     **/

    public void insertImage(Image image, ImageView imageView, Button button, int height, int width) {
        imageView.setImage(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
    }

    @FXML
    public void onUploadImage(ActionEvent actionEvent) throws IOException {
        String url = getFileOfImage();
        Image imageOfGuest = new Image(url, 112, 112, true, false);
        imageView.setImage(imageOfGuest);
    }

    public String getFileOfImage() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open the image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*.gif")
        );
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = fileChooser.showOpenDialog(null);
        String url = "file:///" + file.getPath();
        return url;
    }

    /**
     *
     * With the getters we can set all the text field in 'initialize' if the status is
     * either confirmed or unconfirmed. Can we send some information about particular
     * reservation from the source?
     *
     * */


    @FXML
    public void popupAsCharge(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Scene scene = node.getScene();
        Stage stage = (Stage) scene.getWindow();

        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(stage);

        URL url = getClass().getClassLoader().getResource("group1/stayella/View/ChargesView/index.fxml");
        FXMLLoader loader = new FXMLLoader(url);

        prepareController(loader, getHotel(), getSceneStack());
        Parent page = loader.load();

        ApplicationController controller = loader.getController();

        controller.setHotel(getHotel());
        ControllerCharges controllerCharges = (ControllerCharges) loader.getController();
        if(!charges.isEmpty()) {
            controllerCharges.setChargesForReservation(charges);
            controllerCharges.onResetAction();
        }

        Scene newPage = new Scene(page, 330, 500);

        newStage.setScene(newPage);
        newStage.showAndWait();


        this.charges = controllerCharges.getChargesForReservation();

        setTotalPriceToLabel();
    }
}
