package group1.stayella.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

import group1.stayella.Model.Hotel;
import group1.stayella.Model.Room;

public class ApplicationController implements Initializable {
    private Hotel hotel;
    private Stack<Scene> sceneStack = new Stack<Scene>();

    public ApplicationController() {
    }

    public ApplicationController(Hotel hotel, Stack<Scene> sceneStack) {
        this.hotel = hotel;
        this.sceneStack = sceneStack;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("application controller is loaded");
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setSceneStack(Stack<Scene> scene) {
        this.sceneStack = scene;
    }

    public void pushSceneStack(Scene scene) {
        this.sceneStack.push(scene);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public List<Room> getRooms() {
        if(hotel == null) {
            return null;
        }
        return hotel.getRooms();
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

    public void popUpAs(ActionEvent event, String fxml, Integer with, Integer height) throws IOException {
        Stage newPopup = popup(event, fxml, with, height);
        newPopup.show();
    }

    private Stage transit(ActionEvent event, String fxml, Integer width, Integer height) throws IOException {
        Node node = (Node) event.getSource();
        Scene scene = node.getScene();

        Stage stage = (Stage) scene.getWindow();

        URL url = getClass().getClassLoader().getResource("group1/stayella/View/" + fxml);
        FXMLLoader loader = new FXMLLoader(url);
        pushSceneStack(scene);
        prepareController(loader, getHotel(), sceneStack);
        Parent page = loader.load();

        Scene newPage = new Scene(page, width, height);

        stage.setScene(newPage);
        return stage;
    }

    private Stage popup(ActionEvent event, String fxml, Integer width, Integer height) throws IOException {
        Node node = (Node) event.getSource();
        Scene scene = node.getScene();
        Stage stage = (Stage) scene.getWindow();

        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(stage);

        URL url = getClass().getClassLoader().getResource("group1/stayella/View/" + fxml);
        FXMLLoader loader = new FXMLLoader(url);
        prepareController(loader, hotel, sceneStack);
        Parent page = loader.load();

        ApplicationController controller = loader.getController();
        controller.setHotel(getHotel());

        Scene newPage = new Scene(page, width, height);

        newStage.setScene(newPage);
        return newStage;
    }

    public void closeAction(ActionEvent actionEvent) {
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    public void prepareController(FXMLLoader loader, Hotel hotel, Stack<Scene> sceneStack) {
        loader.setControllerFactory(c -> {
            try {
                ApplicationController controller = (ApplicationController) c.newInstance();
                controller.setHotel(getHotel());
                controller.setSceneStack(sceneStack);
                return controller;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

}
