package org.example.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button buttonBack;
    @FXML
    void initialize()  {
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Authorization.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("МойБанк");
            stage.getIcons().add(new Image("C:\\Users\\cibis\\IdeaProjects\\BANK\\src\\main\\resources\\Icons_and_pictures\\2830284.png"));
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
