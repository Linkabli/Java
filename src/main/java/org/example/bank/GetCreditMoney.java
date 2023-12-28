package org.example.bank;

import ProjectClasses.Customer;
import ProjectClasses.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GetCreditMoney {
    private Customer user;
    private Stage stage;
    @FXML
    private Button GetMoneyAction;
    @FXML
    private TextField DepositField;
    private Transaction tempTransaction;

    public GetCreditMoney(Customer user, Stage stage) {
        this.user = user;
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        GetMoneyAction.setOnAction(actionEvent -> {
            try {
                double balance = Double.parseDouble(DepositField.getText());
                if (balance <= 0) {
                    System.out.println("Введите положительное значение для депозита.");
                    return;
                }
                tempTransaction = new Transaction(user.getAccount(), Double.parseDouble(DepositField.getText()), 3);
                DataBaseHandler dbHandler = new DataBaseHandler();
                dbHandler.updateUserCreditBalance(user, Double.parseDouble(DepositField.getText()), tempTransaction);
                stage.close();
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное числовое значение для депозита.");
            }
        });
    }
}