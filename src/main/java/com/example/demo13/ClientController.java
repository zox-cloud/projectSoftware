package com.example.demo13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientController {

    @FXML
    private StackPane contentArea;

    private Basket basket;
    private IDataBaseConnection dbConnection;

    public ClientController() {
        // Initialize the database connection (Proxy or direct)
        this.dbConnection = new DataBaseConnectionProxy();
        this.basket = new Basket();
    }

    @FXML
    private void initialize() {
        // Optional: Initialize with default view such as product list
        handleViewProducts();
    }

    @FXML
    private void handleViewProducts() {
        // Code to display the list of products
        ListView<Product> listView = new ListView<>();
        // Fetch products from database and add to listView
        contentArea.getChildren().setAll(listView);
    }

    @FXML
    private void handleViewBasket() {
        // Code to display the basket contents
        ListView<Product> listView = new ListView<>();
        // Add products from basket to listView
        contentArea.getChildren().setAll(listView);
    }

    @FXML
    private void handlePlaceOrder() {
        // Code to handle placing an order
        // This might open a new dialog or a new area in the contentArea
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            // Load the login view FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(loader.load() , 400 , 400); // Update the path to your login FXML file

            // Get the current window and set the scene to the login view
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();// signUpBox is the VBox id from your SignUp.fxml
            stage.setScene(scene);

            // Optional: Set the title of the window
            stage.setTitle("Login");

            // Show the new scene
            stage.show();

        } catch (IOException e) {
            e.printStackTrace(); // Log the exception, or show an error dialog
        }
    }
}
