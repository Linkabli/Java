package org.example.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
        DataBaseHandler dbHandler = new DataBaseHandler();
        registrationButton.setOnAction(event -> {
            try {
                dbHandler.signUpUser(name_field.getText().trim(), lastname_field.getText().trim(), login_field.getText().trim(), password_field.getText().trim());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
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
            stage.getIcons().add(new Image("2830284.png"));
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
