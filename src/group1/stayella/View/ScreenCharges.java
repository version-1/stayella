package group1.stayella.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScreenCharges {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        VBox layout = new VBox(15);
        Label messageLabel = new Label();
        messageLabel.setText(message);
        messageLabel.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");

        Button addButton = new Button();
        addButton.setText("ADD CHARGES");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // close the window!
                window.close();
            }
        });

        layout.getChildren().add(messageLabel);
        layout.getChildren().add(addButton);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout, 200, 80);
        scene.getStylesheets().add("sample/View/css/popup.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
