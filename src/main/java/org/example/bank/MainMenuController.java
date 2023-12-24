package org.example.bank;

import ProjectClasses.Customer;
import javafx.fxml.FXML;

import java.sql.ResultSet;

public class MainMenuController {
    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Customer customer = new Customer(login);
        ResultSet result = dbHandler.getUser(customer);
    }

}