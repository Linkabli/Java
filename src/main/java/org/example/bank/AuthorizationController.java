package org.example.bank;

import ProjectClasses.BankSystem;
import ProjectClasses.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizationController {
    @FXML
    private Hyperlink singUpButton;
    @FXML
    private Button signIn;
    @FXML
    private TextField loginText;
    @FXML
    private PasswordField passwordText;
    @FXML
    void initialize()  {
        signIn.setOnAction(event -> {
            try {
                loginUserAction(loginText.getText().trim(), passwordText.getText().trim());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
    private void loginUserAction(String login, String password) throws SQLException {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Customer customer = new Customer(login, password);
        ResultSet result = dbHandler.getUser(customer);
        int i = 0;
        while(result.next()) {
        i++;
        }
        if (i >= 1) {
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
        }
    }

}


