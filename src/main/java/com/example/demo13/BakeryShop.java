package com.example.demo13;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BakeryShop extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryShop.class.getResource("signUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400 , 400);

        primaryStage.setTitle("Bakery Shop Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}