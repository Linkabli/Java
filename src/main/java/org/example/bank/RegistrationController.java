package org.example.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    public Hyperlink HyperlinkToSingIn;
    @FXML
    void initialize()  {
        HyperlinkToSingIn.setOnAction(event -> {
            HyperlinkToSingIn.getScene().getWindow().hide();

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
            //stage.getIcons().add(new Image("2830284.png"));
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
