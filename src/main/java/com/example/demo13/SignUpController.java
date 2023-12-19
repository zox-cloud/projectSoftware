package com.example.demo13;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private ComboBox<String> accountTypeComboBox;

    @FXML
    private Label statusLabel;

    private IDataBaseConnection dbConnection;

    public SignUpController() {
        // Initialize your database connection here
        // Example: this.dbConnection = new DataBaseConnectionProxy();
    }

    @FXML
    protected void handleRegisterAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String accountType = accountTypeComboBox.getSelectionModel().getSelectedItem();

        if (!password.equals(confirmPassword)) {
            statusLabel.setText("Passwords do not match.");
            return;
        }

        if (username.isEmpty() || password.isEmpty() || accountType == null) {
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        try {


            // Perform your registration logic here
            // For example: dbConnection.addUser(username, password, accountType);
            statusLabel.setText("Registration successful. Please log in.");
        } catch (Exception e) {
            statusLabel.setText("Registration failed: " + e.getMessage());
        }
    }





    @FXML
    protected void handleSwitchToLogin(ActionEvent event) {
        try {
            // Change "Login.fxml" to the path of your login page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

            Scene loginScene = new Scene(loader.load() , 400 , 400);

            // Get the stage from the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginScene);
            stage.show();
        } catch (IOException e) {
            statusLabel.setText("Failed to switch to the login page: " + e.getMessage());
        }
    }

    // Additional methods and logic as required
}
