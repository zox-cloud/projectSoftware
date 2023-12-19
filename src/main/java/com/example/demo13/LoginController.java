package com.example.demo13;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginStatusLabel;



    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            UserAccount user = login(username, password);
            if (user != null) {
                loadAppropriateScene(user);
            } else {
                loginStatusLabel.setText("Invalid login credentials.");
            }
        } catch (Exception e) {
            loginStatusLabel.setText("Error: " + e.getMessage());
        }
    }

    private UserAccount login(String username, String password) throws SQLException {
        IDataBaseConnection dbConnection = new DataBaseConnectionProxy();
        String accountType = dbConnection.checkUser(username, password);
        if ("admin".equalsIgnoreCase(accountType)) {
            return new Admin(username);
        } else if ("client".equalsIgnoreCase(accountType)) {
            return new Client(username);
        } else {
            return null;
        }
    }

    private void loadAppropriateScene(UserAccount user) throws IOException {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Scene scene = null;
        FXMLLoader loader = null;

        if (user instanceof Admin) {
            loader = new FXMLLoader(getClass().getResource("AdminPanel.fxml"));

            scene = new Scene(loader.load() , 400 , 400);
        } else if (user instanceof Client) {
            loader = new FXMLLoader(getClass().getResource("ClientPanel.fxml"));
            scene = new Scene(loader.load() , 400  ,400);
        }

        if (scene != null) {
            stage.setScene(scene);
        }
    }


}
