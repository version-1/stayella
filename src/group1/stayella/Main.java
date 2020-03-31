package group1.stayella;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("View/sample.fxml"));
    StackPane stackPane = new StackPane();
    stackPane.getChildren().add(root);

    primaryStage.setTitle("Stayella");
    Scene boardScene = new Scene(stackPane, 300, 330);

    primaryStage.setScene(boardScene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
