package com.example.demo13;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class AdminController {
    public VBox adminPanel;
    @FXML
    private ListView<Client> usersListView;

    @FXML
    private StackPane contentArea;
    @FXML
    private void initialize() {
        // Assuming your VBox or another parent element is accessible as 'adminPanel'
        adminPanel.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }

    public AdminController() {
        // Initialize any necessary components
    }

    @FXML
    private void handleAddNewProduct() {
        // Code to display add new product form
    }

    @FXML
    private void handleUpdateProductPrice() {
        // Code to display update product price form
    }

    @FXML
    private void handleDeleteProduct() {
        // Code to handle product deletion
    }

  // This will display a list of usernames as strings

    @FXML
    private void handleViewUsers() throws SQLException {

    }

    @FXML
    private void handleViewProducts() {
        // Code to display a list of products
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


    // Additional methods and logic as required
}
