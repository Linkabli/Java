package org.example.bank;

import ProjectClasses.Customer;
import ProjectClasses.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransactionToClient {
    private Customer user;
    private double newBalance;
    @FXML
    private TextField login;
    @FXML
    private TextField amount;
    private Stage stage;
    @FXML
    private Button TransactionButton;
    private Transaction tempTransaction;

    TransactionToClient(Customer user, Stage stage) {
        this.user = user;
        this.stage = stage;
    }
    @FXML
    public void initialize() {
        TransactionButton.setOnAction(actionEvent -> {
            DataBaseHandler dbHandler = new DataBaseHandler();
            double amountMeaning = Double.parseDouble(amount.getText());
            tempTransaction = new Transaction(user.getAccount(), Double.parseDouble(amount.getText()), 2);
            String loginMeaning = login.getText();
            dbHandler.TransactionToClient(user, loginMeaning, amountMeaning, tempTransaction);
            stage.close();
        });
    }
}
