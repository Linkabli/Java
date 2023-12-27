package org.example.bank;

import ProjectClasses.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DepositScene {
    @FXML
    private Button ButtonDepositAction;
    @FXML
    private TextField DepositField;
    private Customer user;
    private Stage stage;
    public DepositScene(Customer user, Stage stage) {
        this.user = user;
        this.stage = stage;
    }
    @FXML
    void initialize() {
        ButtonDepositAction.setOnAction(actionEvent -> {
            double balance = Double.parseDouble(DepositField.getText());
            DataBaseHandler dbHandler = new DataBaseHandler();
            dbHandler.updateUserBalance(user, balance);
            stage.close();
        });
        System.out.println(user.getLastname());
    }
}
