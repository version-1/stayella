package group1.stayella;

import java.net.URL;

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
    URL url = getClass().getResource("View/index.fxml");
    Parent root = FXMLLoader.load(url);
    Scene homeScene = new Scene(root, 500,500);

    primaryStage.setScene(homeScene);
    primaryStage.show();
  }
}
