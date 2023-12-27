package org.example.bank;

import ProjectClasses.Customer;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class TransactionTable {
    private Stage stage;
    private Customer user;
    public TransactionTable(Customer user, Stage stage) {
        this.stage = stage;
        this.user = user;
    }
    @FXML
    void initialize() {

    }

}
