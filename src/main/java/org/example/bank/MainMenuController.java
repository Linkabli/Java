package org.example.bank;

import ProjectClasses.Account;
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

    public MainMenuController(String login) {
        this.username = login;
    }

    @FXML
    void initialize() {
        Customer signedUser = ReturnNewDATA();
        if (signedUser != null) {
            UpdateScene(signedUser);
        } else {
            System.out.println("Пользователь не найден.");
        }

        DepositButton.setOnAction(actionEvent -> {
            try {
                DepositButton(signedUser);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
            DepositStage.showAndWait(); // Ждем закрытия окна DepositScene перед продолжением

            UpdateScene(ReturnNewDATA()); // Обновляем главный экран после закрытия окна DepositScene

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
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
        CreditBalance.setText("Кредитный баланс: " + creditAccount.getBalance() + " ₽ / "+ creditAccount.getCreditLimit() + " ₽");
        System.out.println(user.getBalance());
    }
}
