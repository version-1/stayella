package group1.stayella.Controller;

import group1.stayella.View.ChargesView.ScreenCharges;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {
    @FXML
    Image image;
    @FXML
    ImageView imageView;

    @FXML
    Button buttonEdit;
    @FXML
    Image imageEdit;
    @FXML
    ImageView imageEditView;

    @FXML
    Button buttonCard;
    @FXML
    Image imageCard;
    @FXML
    ImageView imageCardView;

    @FXML
    Button buttonAdditions;
    @FXML
    Image imageAdditions;
    @FXML
    ImageView imageAdditionsView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTqWGB5YLwdAKCrHNiw9_I5jXeWHDlGHh83anl58WuJ4WwhzslJ&usqp=CAU");
        imageView.setImage(image);
        imageEdit = new Image("https://3aoh9sn3um-flywheel.netdna-ssl.com/wp-content/uploads/2017/01/edit-1-06-17-300x300.png");
        imageEditView = new ImageView();
        imageEditView.setImage(imageEdit);
        imageEditView.setFitHeight(25);
        imageEditView.setFitWidth(25);
        imageEditView.setPreserveRatio(true);
        buttonEdit.setGraphic(imageEditView);

        imageCard = new Image("https://www.nerdwallet.com/assets/blog/wp-content/uploads/2018/03/creditstacks.card_.front_.back-story-600x338.png");
        imageCardView = new ImageView();
        imageCardView.setImage(imageCard);
        imageCardView.setFitWidth(240);
        imageCardView.setFitWidth(120);
        imageCardView.setPreserveRatio(true);
        buttonCard.setGraphic(imageCardView);
        buttonCard.setOnAction(e -> ScreenCharges.display("Additions", "Additions"));

        imageAdditions = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRz2AEfespdhCgKtTN2R-o6maiMq1_SuKR7q9drWDi6NGJqxkhQ&usqp=CAU");
        imageAdditionsView = new ImageView();
        imageAdditionsView.setImage(imageAdditions);
        imageAdditionsView.setFitWidth(30);
        imageAdditionsView.setFitWidth(30);
        imageAdditionsView.setPreserveRatio(true);
        buttonAdditions.setGraphic(imageAdditionsView);
        buttonAdditions.setOnAction(e -> ScreenCharges.display("Additions", "Additions"));
    }
}
