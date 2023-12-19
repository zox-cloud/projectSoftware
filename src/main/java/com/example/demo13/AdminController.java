package com.example.demo13;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AdminController {
    @FXML
    private VBox adminPanel;
    @FXML
    private ListView<Client> usersListView;
    @FXML
    private ListView<Product> productsListView;
    @FXML
    private StackPane contentArea;

    private IDataBaseConnection dbConnection;
    @FXML
    private void initialize() {
        // Assuming your VBox or another parent element is accessible as 'adminPanel'
        adminPanel.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


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

    public AdminController() {
        // Initialize any necessary components
        dbConnection = new DataBaseConnectionProxy();
    }

    @FXML
    private void handleAddNewProduct() {
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(adminPanel.getScene().getWindow());
        dialog.setTitle("Add New Product");

        // Set the button types.
        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        // Create the product ID, name, and price labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField productIdField = new TextField();
        productIdField.setPromptText("Product ID");
        TextField productNameField = new TextField();
        productNameField.setPromptText("Product Name");
        TextField productPriceField = new TextField();
        productPriceField.setPromptText("Product Price");

        grid.add(new Label("Product ID:"), 0, 0);
        grid.add(productIdField, 1, 0);
        grid.add(new Label("Product Name:"), 0, 1);
        grid.add(productNameField, 1, 1);
        grid.add(new Label("Product Price:"), 0, 2);
        grid.add(productPriceField, 1, 2);

        dialog.getDialogPane().setContent(grid);

        // Request focus on the product ID field by default.
        productIdField.requestFocus();

        // Convert the result when the add button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                try {
                    int productId = Integer.parseInt(productIdField.getText());
                    String productName = productNameField.getText();
                    int productPrice = Integer.parseInt(productPriceField.getText());
                    // Insert product into the database
                    dbConnection.addProduct(productId , productName , productPrice);
                    showAlert("Success", "Product added successfully.");
                } catch (NumberFormatException e) {
                    showAlert("Error", "Please enter valid numbers for product ID and price.");
                } catch (SQLException e) {
                    showAlert("Error", "Failed to add product: " + e.getMessage());
                }
            }
            return null;
        });

        dialog.showAndWait();
    }


    @FXML
    private void handleUpdateProductPrice() {
        try {
            // Load the update product price form FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateProductPriceForm.fxml"));
            Parent updateProductPriceForm = loader.load();

            // Set the form into the content area
            contentArea.getChildren().setAll(updateProductPriceForm);
        } catch (IOException e) {
            showAlert("Error", "Failed to load the update product price form.");
        }
    }

    @FXML
    private void handleDeleteProduct() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Delete Product");
        dialog.setHeaderText("Product Deletion");
        dialog.setContentText("Please enter the ID of the product to delete:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(productId -> {
            try {
                int id = Integer.parseInt(productId);
                dbConnection.deleteProduct(id);
                showAlert("Success", "Product successfully deleted.");
            } catch (NumberFormatException e) {
                showAlert("Error", "Invalid product ID format.");
            } catch (SQLException e) {
                showAlert("Error", "Failed to delete the product: " + e.getMessage());
            }
        });
    }

  // This will display a list of usernames as strings

    @FXML
    private void handleViewUsers() throws SQLException {
        List<Client> clients = dbConnection.getClients();
        usersListView.getItems().setAll(clients);

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
    private void handleLogout(ActionEvent event) {
        try {
            // Load the login view FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
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
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    // Additional methods and logic as required
}
