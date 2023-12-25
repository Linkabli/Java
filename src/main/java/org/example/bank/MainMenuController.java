package org.example.bank;

import ProjectClasses.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    private String username;
    @FXML
    private Label HelloLabel;
    @FXML
    private Label BalanceLabel;
    @FXML
    private Label CreditBalance;

    public MainMenuController(String login) {
        this.username = login;
    }
    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Customer signedUser = dbHandler.getUserDataByName(username);

        if (signedUser != null) {
            HelloLabel.setText("Здравствуйте, " + signedUser.getFirstname());
            BalanceLabel.setText("Основной баланс: " + signedUser.getBalance() + " ₽");
            CreditBalance.setText("Кредитный баланс: " + signedUser.getBalance() + " ₽");

        } else {
            System.out.println("User not found.");
        }
    }
}