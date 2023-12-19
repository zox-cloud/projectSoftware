package com.example.demo13;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;

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
    private void handleLogout() {
        // Code to handle logout and return to the login screen
    }

    // Additional methods and logic as required
}
