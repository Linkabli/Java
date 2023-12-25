package org.example.bank;

import ProjectClasses.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DepositScene {
    @FXML
    private Button ButtonDepositAction;
    @FXML
    private TextField DepositField;
    private Customer user;
    public DepositScene(Customer user) {
        this.user = user;
    }
    @FXML
    void initialize() {
        System.out.println(user.getLastname());
    }
}
