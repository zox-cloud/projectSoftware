package com.example.demo13;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.sql.SQLException;

public class UpdatePriceController {
    @FXML
    private TextField productIdField;
    @FXML
    private TextField newPriceField;

    private IDataBaseConnection dbConnection;

    public UpdatePriceController() {

        dbConnection = new DataBaseConnectionProxy();
    }

    @FXML
    private void handleUpdatePrice() {
        try {
            int productId = Integer.parseInt(productIdField.getText());
            int  newPrice = Integer.parseInt(newPriceField.getText());

            dbConnection.updatePrice(productId, newPrice);
            showAlert("Success", "Product price updated successfully.");
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter valid numbers for product ID and price.");
        } catch (SQLException e) {
            showAlert("Database Error", "Failed to update product price: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
