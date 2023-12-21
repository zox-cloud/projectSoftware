package com.example.demo13;//package com.example.demo13;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.ListCell;
//import javafx.scene.layout.StackPane;
//import javafx.scene.control.ListView;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class ClientController {
//
//    @FXML
//    private StackPane contentArea;
//    @FXML
//    private ListView<Product> productsListView;
//
//    private Basket basket;
//    private IDataBaseConnection dbConnection;
//
//    public ClientController() {
//        // Initialize the database connection (Proxy or direct)
//        this.dbConnection = new DataBaseConnectionProxy();
//        this.basket = new Basket();
//    }
//
//    @FXML
//    private void initialize() {
//        // Optional: Initialize with default view such as product list
//        handleViewProducts();
//
//    }
//
//
//
//    @FXML
//    private void handleViewProducts() {
//        ListView<Product> productsListView = new ListView<>();
//        try {
//            List<Product> products = dbConnection.getProducts();
//            productsListView.getItems().addAll(products);
//            productsListView.setCellFactory(lv -> new ListCell<Product>() {
//                @Override
//                protected void updateItem(Product product, boolean empty) {
//                    super.updateItem(product, empty);
//                    if (empty || product == null) {
//                        setText(null);
//                    } else {
//                        setText(product.getName() + " - $" + product.getPrice());
//                    }
//                }
//            });
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle exception properly
//        }
//        contentArea.getChildren().setAll(productsListView);
//    }
//
//
//
//
//
//
//
//    @FXML
//    private void handleViewBasket() {
//        ListView<String> basketListView = new ListView<>();
//        for (Product product : basket.getProducts()) {
//            basketListView.getItems().add(product.getName() + " - $" + product.getPrice());
//        }
//        contentArea.getChildren().setAll(basketListView);
//    }
//
//    @FXML
//    private void handlePlaceOrder() {
//        // Example: Show a confirmation dialog
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Place order for $" + basket.getTotalPrice() + "?", ButtonType.YES, ButtonType.NO);
//        alert.showAndWait().ifPresent(response -> {
//            if (response == ButtonType.YES) {
//                // Code to place the order
//                System.out.println("Order placed");
//                basket.clear(); // Clear the basket after placing the order
//            }
//        });
//    }
//    @FXML
//    private void handleLogout(ActionEvent event) {
//        try {
//            // Load the login view FXML
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
//            Scene scene = new Scene(loader.load() , 400 , 400); // Update the path to your login FXML file
//
//            // Get the current window and set the scene to the login view
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();// signUpBox is the VBox id from your SignUp.fxml
//            stage.setScene(scene);
//
//            // Optional: Set the title of the window
//            stage.setTitle("Sign Up");
//
//            // Show the new scene
//            stage.show();
//
//        } catch (IOException e) {
//            e.printStackTrace(); // Log the exception, or show an error dialog
//        }
//    }
//}



//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//    import javafx.scene.control.ListView;
//    import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class ClientController {
//
//    @FXML
//    private StackPane contentArea;
//
//    private Basket basket;
//    private IDataBaseConnection dbConnection;
//
//    public ClientController() {
//        // Initialize the database connection (Proxy or direct)
//        this.dbConnection = new DataBaseConnectionProxy();
//        this.basket = new Basket();
//    }
//
//    @FXML
//    private void initialize() {
//        // Optional: Initialize with default view such as product list
//        handleViewProducts();
//    }
//    @FXML
//    private void handleAddProductToBasket(){}
//
//    @FXML
//    private void handleViewProducts() {
//        // Code to display the list of products
//        ListView<Product> listView = new ListView<>();
//        // Fetch products from database and add to listView
//        contentArea.getChildren().setAll(listView);
//    }
//
//    @FXML
//    private void handleViewBasket() {
//        // Code to display the basket contents
//        ListView<Product> listView = new ListView<>();
//        // Add products from basket to listView
//        contentArea.getChildren().setAll(listView);
//    }
//
//    @FXML
//    private void handlePlaceOrder() {
//        // Code to handle placing an order
//        // This might open a new dialog or a new area in the contentArea
//    }
//
//    @FXML
//    private void handleLogout(ActionEvent event) {
//        try {
//            // Load the login view FXML
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
//            Scene scene = new Scene(loader.load() , 400 , 400); // Update the path to your login FXML file
//
//            // Get the current window and set the scene to the login view
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();// signUpBox is the VBox id from your SignUp.fxml
//            stage.setScene(scene);
//
//            // Optional: Set the title of the window
//            stage.setTitle("Sign Up");
//
//            // Show the new scene
//            stage.show();
//
//        } catch (IOException e) {
//            e.printStackTrace(); // Log the exception, or show an error dialog
//        }
//    }
//}


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClientController {

    @FXML
    private StackPane contentArea;
    @FXML
    private ListView<Product> productsListView; // Assuming you have this ListView in your FXML
    @FXML
    private TextField productIdField;

    private Basket basket;
    private IDataBaseConnection dbConnection;

    public ClientController() {
        this.dbConnection = new DataBaseConnectionProxy();
        this.basket = new Basket();
    }

    @FXML
    private void initialize() {
        productsListView.setCellFactory(lv -> new ListCell<Product>() {
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if (empty || product == null) {
                    setText(null);
                } else {
                    setText( product.getId() + product.getName() + " - $" + product.getPrice());
                }
            }
        });

        // Load products initially or when needed
        handleViewProducts();

    }

    @FXML
    private void handleAddProductToBasket() {
        try {
            int productId = Integer.parseInt(productIdField.getText());
            Product product = dbConnection.getProductById(productId);
            if (product != null) {
                basket.addProduct(product);
                showAlert("Success", "Added " + product.getName() + " to basket.");
            } else {
                showAlert("Error", "Product not found.");
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid product ID.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void handleViewProducts() {
        // Clear current products
        productsListView.getItems().clear();

        // Fetch and display products
        try {
            List<Product> products = dbConnection.getProducts();
            productsListView.getItems().addAll(products);
        } catch (SQLException e) {
            showAlert("Error", "Failed to load products: " + e.getMessage());
        }
    }
    @FXML
    private void handleViewBasket() {
        ListView<String> basketListView = new ListView<>();
        for (Product product : basket.getProducts()) {
            basketListView.getItems().add(product.getName() + " - $" + product.getPrice());
        }
        if (basketListView.getItems().isEmpty()) {
            basketListView.getItems().add("Your basket is empty.");
        }
        contentArea.getChildren().setAll(basketListView);
    }

    @FXML
    private void handlePlaceOrder() {
        if (basket.getProducts().isEmpty()) {
            showAlert("Empty Basket", "Your basket is empty.");
            return;
        }
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Confirm your order for $" + basket.getTotalPrice() + "?", ButtonType.YES, ButtonType.CANCEL);
        confirmation.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                // Process the order
                basket.clear();
                showAlert("Order Placed", "Your order has been placed.");
            }
        });
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Scene scene = new Scene(loader.load() , 400 , 400); // Update the path to your login FXML file


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();// signUpBox is the VBox id from your SignUp.fxml
            stage.setScene(scene);


            stage.setTitle("Sign Up");


            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, content);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
