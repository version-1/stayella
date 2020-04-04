package group1.stayella;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

  public static void main(String[] args) {
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
