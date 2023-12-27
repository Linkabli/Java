package org.example.bank;

import ProjectClasses.CreditAccount;
import ProjectClasses.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

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
    @FXML
    private Button TransactionHistory;
    @FXML
    private Button TransanctionToClient;

    public MainMenuController(String login) {
        this.username = login;
    }

    @FXML
    void initialize() {
        AtomicReference<Customer> signedUser = new AtomicReference<>(ReturnNewDATA());
        if (signedUser.get() != null) {
            UpdateScene(signedUser.get());
        } else {
            System.out.println("Пользователь не найден.");
        }
        DepositButton.setOnAction(actionEvent -> {
            try {
                signedUser.set(DepositButton(signedUser.get()));
                UpdateScene(signedUser.get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        TransactionHistory.setOnAction(actionEvent -> {
            OpenTransactionHistory(signedUser.get());
        });
        TransanctionToClient.setOnAction(actionEvent -> {
            signedUser.set(TransanctionToClientAction(signedUser.get()));
            UpdateScene(signedUser.get());
        });
    }
    public Customer DepositButton(Customer user) throws IOException {
        Stage DepositStage = new Stage();
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("DepositScene.fxml"));

            Loader.setControllerFactory(controllerClass -> {
                if (controllerClass == DepositScene.class) {
                    return new DepositScene(user, DepositStage);
                } else {
                    try {
                        return controllerClass.newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            Parent root = Loader.load();
            Scene depositScene = new Scene(root, 250, 213);
            DepositStage.setScene(depositScene);
            DepositStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReturnNewDATA();
    }

    public Customer ReturnNewDATA() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Customer user = dbHandler.getUserDataByName(username);
        return user;
    }

    public void UpdateScene(Customer user) {
        CreditAccount creditAccount = user.getCreditAccount();
        HelloLabel.setText("Здравствуйте, " + user.getFirstname());
        BalanceLabel.setText("Основной баланс: " + user.getBalance() + " ₽");
        CreditBalance.setText("Кредитный баланс: " + creditAccount.getBalance() + " ₽ / " + creditAccount.getCreditLimit() + " ₽");
        System.out.println(user.getBalance());
    }

    public void OpenTransactionHistory(Customer user) {
        Stage TransactionsStage = new Stage();
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("TransactionTable.fxml"));

            Loader.setControllerFactory(controllerClass -> {
                if (controllerClass == TransactionTable.class) {
                    return new TransactionTable(user, TransactionsStage);
                } else {
                    try {
                        return controllerClass.newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            Parent root = Loader.load();
            Scene TransanctionsScene = new Scene(root, 600, 400);
            TransactionsStage.setScene(TransanctionsScene);
            TransactionsStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Customer TransanctionToClientAction(Customer user) {
        Stage TransanctionToClientStage = new Stage();
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("TransactionToClient.fxml"));
            Loader.setControllerFactory(controllerClass -> {
                if (controllerClass == TransactionToClient.class) {
                    return new TransactionToClient(user, TransanctionToClientStage);
                } else {
                    try {
                        return controllerClass.newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            Parent root = Loader.load();
            Scene TransanctionToClientScene = new Scene(root);
            TransanctionToClientStage.setScene(TransanctionToClientScene);
            TransanctionToClientStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReturnNewDATA();
    }
}