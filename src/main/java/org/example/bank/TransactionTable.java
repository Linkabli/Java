package org.example.bank;

import ProjectClasses.Customer;
import ProjectClasses.Transaction;
import ProjectClasses.TransactionHistory;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TransactionTable {
    private Stage stage;
    private Customer user;
    private int counter;
    private String login;
    private String name;
    @FXML
    private TableView<Transaction> TableView;
    @FXML
    private TableColumn<Transaction, String> ColumnNumber;
    @FXML
    private TableColumn<Customer, String> ColumnLogin;
    @FXML
    private TableColumn<Customer, String> ColumnName;
    @FXML
    private TableColumn<Transaction, Double> ColumnSum;
    @FXML
    private TableColumn<Transaction, String> ColumnType;
    @FXML
    private TableColumn<Transaction, Date> ColumnDate;

    public TransactionTable(Customer user, Stage stage) {
        this.stage = stage;
        this.user = user;
    }
    @FXML
    void initialize() throws SQLException {
        login = user.getLogin();
        name = user.getFirstname();

        ColumnLogin.setCellValueFactory(cellData -> new SimpleStringProperty(login));
        ColumnName.setCellValueFactory(cellData -> new SimpleStringProperty(name));
        ColumnSum.setCellValueFactory(new PropertyValueFactory<>("amount"));
        ColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        ColumnDate.setCellValueFactory(new PropertyValueFactory<>("currentDate"));

        TableView.getItems().clear();

        DataBaseHandler dbHandler = new DataBaseHandler();
        TransactionHistory transactionHistory = new TransactionHistory();
        ArrayList<Transaction> transactions = transactionHistory.getList();
        transactions = dbHandler.getTransactionHistoryFromDatabase(transactions, user);
        loadDataToTable(transactionHistory, TableView);
    }

    private void loadDataToTable(TransactionHistory transactionHistory, TableView tableView) {
        ArrayList<Transaction> transactions = transactionHistory.getList();
        tableView.getItems().setAll(transactions);
    }
}