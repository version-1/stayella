package group1.stayella;

import java.util.List;

import group1.stayella.Model.Hotel;
import group1.stayella.Model.CSV.Factory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

  public static void main(String[] args) {
    List<Hotel> hotel = Factory.initialize();
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Stayella");
    Parent homeRoot = FXMLLoader.load(getClass().getResource("View/index.fxml"));
    Scene homeScene = new Scene(homeRoot, 235,150);

    Parent reservationRoot = FXMLLoader.load(getClass().getResource("View/ReservationView/index.fxml"));
    Scene reservationScene = new Scene(reservationRoot, 720, 1000);

    primaryStage.setScene(reservationScene);
    primaryStage.show();
  }
}
