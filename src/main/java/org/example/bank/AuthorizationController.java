package org.example.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationController {
    @FXML
    private Hyperlink singUpButton;
    @FXML
    private Button signIn;
    @FXML
    void initialize()  {
        signIn.setOnAction(event -> {
            signIn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MainMenu.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("МойБанк");
            //stage.getIcons().add(new Image("src/main/resources/Icons_and_pictures/2830284.png"));
            stage.setScene(new Scene(root));
            stage.show();
        });
        singUpButton.setOnAction(event -> {
            singUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Registration.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("МойБанк");
            //stage.getIcons().add(new Image("src/main/resources/Icons_and_pictures/2830284.png"));
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

}


