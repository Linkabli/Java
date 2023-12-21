package org.example.bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BANK extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader authorizationLoader = new FXMLLoader(BANK.class.getResource("Authorization.fxml"));
        Scene authorizationScene = new Scene(authorizationLoader.load(), 550, 450);

        primaryStage.setTitle("МойБанк");
        primaryStage.setScene(authorizationScene);
        primaryStage.show();
        //primaryStage.getIcons().add(new Image("C:\\Users\\cibis\\IdeaProjects\\BANK\\src\\main\\resources\\Icons_and_pictures\\2830284.png"));



    }

    public static void main(String[] args) {
        launch();
    }
}