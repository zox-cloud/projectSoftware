package com.example.demo13;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.sql.SQLException;
import java.util.List;

public class AdminController {

    @FXML
    private ListView<String> productsList; // Assuming a ListView to display products

    @FXML
    private ListView<String> clientsList; // Assuming a ListView to display clients

    @FXML
    private void viewProducts() {
        try {
            List<Product> products = DatabaseConnection.getInstance().getProducts();
            for (Product product : products) {
                // Assuming Product has a toString() method that formats it nicely
                productsList.getItems().add(product.toString());
            }
        } catch (SQLException e) {
            // Handle SQL exception
        }
    }

    @FXML
    private void viewClients() {
        try {
            List<Client> clients = DatabaseConnection.getInstance().getClients();
            for (Client client : clients) {
                // Assuming Client has a toString() method that formats it nicely
                clientsList.getItems().add(client.toString());
            }
        } catch (SQLException e) {
            // Handle SQL exception
        }
    }

    // Additional methods to handle other admin functionalities
}
