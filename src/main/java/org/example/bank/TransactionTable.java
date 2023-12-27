package org.example.bank;

import ProjectClasses.Customer;
import ProjectClasses.TransactionHistory;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.Date;

public class TransactionTable {
    private Stage stage;
    private Customer user;
    @FXML
    private TableView<TransactionHistory> TableView;
    @FXML
    private TableColumn<TransactionHistory, String> ColumnNumber;
    @FXML
    private TableColumn<TransactionHistory, String> ColumnLogin;
    @FXML
    private TableColumn<TransactionHistory, Double> ColumnSum;
    @FXML
    private TableColumn<TransactionHistory, String> ColumnType;
    @FXML
    private TableColumn<TransactionHistory, Date> ColumnDate;
    public TransactionTable(Customer user, Stage stage) {
        this.stage = stage;
        this.user = user;
    }
    @FXML
    void initialize() {
        TransactionHistory transactionHistory = new TransactionHistory();
        DataBaseHandler dbHandler = new DataBaseHandler();
    }

}
