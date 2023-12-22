package org.example.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    public Hyperlink HyperlinkToSingIn;
    @FXML
    public TextField name_field;
    @FXML
    public TextField lastname_field;
    @FXML
    public TextField login_field;
    @FXML
    public TextField password_field;
    @FXML
    public Button registrationButton;
    @FXML
    void initialize()  {
        registrationButton.setOnAction(event -> {
        String fistNameText = name_field.getText().trim();
        String lastnameText = lastname_field.getText().trim();
        String loginText = login_field.getText().trim();
        String passwordText = password_field.getText().trim();
        if(!fistNameText.isEmpty() &&
                !lastnameText.isEmpty() &&
                !loginText.isEmpty() &&
                !passwordText.isEmpty()) {
            registerUser(fistNameText, lastnameText, loginText, passwordText);
            registrationButton.getScene().getWindow().hide();
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
        }
        });
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

    public void registerUser(String name, String lastname, String login, String password) {

    }
}
