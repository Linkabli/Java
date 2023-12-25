package org.example.bank;

import ProjectClasses.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    private String username;
    @FXML
    private Label HelloLabel;
    @FXML
    private Label BalanceLabel;
    @FXML
    private Button DepositButton;
    @FXML
    private Label CreditBalance;

    public MainMenuController(String login) {
        this.username = login;
    }
    @FXML
    void initialize() {
        Customer signedUser = ReturnNewDATA();
        if (signedUser != null) {
            UpdateScene(signedUser);
        } else {
            System.out.println("User not found.");
        }
        DepositButton.setOnAction(actionEvent -> {
            try {
                DepositButton(signedUser);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public Customer DepositButton(Customer user) throws IOException {
        Stage DepositStage = new Stage();
        DataBaseHandler dbHandler = new DataBaseHandler();
        FXMLLoader Loader = new FXMLLoader(BANK.class.getResource("DepositScene.fxml"));
        Scene depositScene = new Scene(Loader.load(), 250, 213);
        DepositStage.setScene(depositScene);
        DepositStage.show();
        return user;
    }
    public Customer ReturnNewDATA() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Customer user = dbHandler.getUserDataByName(username);
        return user;
    }
    public void UpdateScene(Customer user) {
        HelloLabel.setText("Здравствуйте, " + user.getFirstname());
        BalanceLabel.setText("Основной баланс: " + user.getBalance() + " ₽");
        CreditBalance.setText("Кредитный баланс: " + user.getBalance() + " ₽");
    }
}