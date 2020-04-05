package group1.stayella.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import group1.stayella.Model.Hotel;

public class ApplicationController implements Initializable {
    private Hotel hotel;
    private Stack<Scene> sceneStack = new Stack<Scene>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("application controller is loaded");
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void pushSceneStack(Scene scene) {
        this.sceneStack.push(scene);
    }

    public Hotel getHotel() {
        return hotel;
    }

    @FXML
    public void goBack(ActionEvent event) {
        if (sceneStack.size() == 0) {
            return;
        }
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Scene previousStack = sceneStack.pop();
        stage.setScene(previousStack);
    }

    public Stage transitTo(ActionEvent event, String fxml, Integer width, Integer height) throws IOException {
        return transit(event, fxml, width, height);
    }

    public Stage transitTo(ActionEvent event, String fxml) throws IOException {
        return transit(event, fxml, 500, 500);
    }

    public Stage popUpTo(String fxml, Integer with, Integer height) throws IOException {
        return popup(fxml, with, height);
    }


    private Stage transit(ActionEvent event, String fxml, Integer width, Integer height) throws IOException {
        Node node = (Node) event.getSource();
        Scene scene = node.getScene();
        Stage stage = (Stage) scene.getWindow();
        URL url = getClass().getClassLoader().getResource("group1/stayella/View/" + fxml);
        FXMLLoader loader = new FXMLLoader(url);
        Parent page = loader.load();

        ApplicationController controller = loader.getController();
        controller.setHotel(getHotel());
        controller.pushSceneStack(scene);

        Scene newPage = new Scene(page, width, height);

        stage.setScene(newPage);
        return stage;
    }

    private Stage popup(String fxml, Integer width, Integer height) throws IOException {
        Stage stage = new Stage();
        URL url = getClass().getClassLoader().getResource("group1/stayella/View/" + fxml);
        FXMLLoader loader = new FXMLLoader(url);
        Parent page = loader.load();

        ApplicationController controller = loader.getController();
        controller.setHotel(getHotel());

        Scene newPage = new Scene(page, width, height);

        stage.setScene(newPage);
        return stage;
    }
}
