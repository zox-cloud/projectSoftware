package com.example.demo13;
// TODO: 13.12.2023 Singleton pattern - database connection
// TODO: 13.12.2023 factory pattern - account creation (admin , client)

// TODO: 13.12.2023 strategy pattern  - kind a payment , paypal , visa , crypto payments
// TODO: 17.12.2023  proxy


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// TODO: 15.12.2023 proxy
// TODO: 15.12.2023




public class Main{
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        IDataBaseConnection dbConnection = new  DataBaseConnectionProxy();
//        boolean running = true;
//
//        while (running) {
//            System.out.println("Welcome to the Bakery Shop!");
//            System.out.println("1. Login");
//            System.out.println("2. Register");
//            System.out.println("3. Exit");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//
//            switch (choice) {
//                case 1 -> {
//                    // Login functionality
//                    UserAccount user = login(scanner, dbConnection);
//                    if (user != null) {
//                        if (user instanceof Admin) {
//                            performAdminActions((Admin) user, scanner, dbConnection);
//                        } else if (user instanceof Client) {
//                            performClientActions((Client) user, scanner, dbConnection);
//                        }
//                    }
//                }
//                case 2 ->
//                    // Registration functionality
//                        register(scanner, dbConnection);
//                case 3 -> running = false;
//                default -> System.out.println("Invalid option.");
//            }
//        }
//        scanner.close();



    }


    // TODO: 15.12.2023 Registration
//    private static UserAccount login(Scanner scanner, IDataBaseConnection dbConnection) {
//        System.out.print("Enter username: ");
//        String username = scanner.nextLine();
//        System.out.print("Enter password: ");
//        String password = scanner.nextLine();
//
//        try {
//            String accountType = dbConnection.checkUser(username, password);
//            if ("admin".equalsIgnoreCase(accountType)) {
//                return new Admin(username);  // Directly creating an Admin instance
//            } else if ("client".equalsIgnoreCase(accountType)) {
//                return new Client(username); // Directly creating a Client instance
//            } else {
//                System.out.println("Invalid login credentials.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Database error: " + e.getMessage());
//        }
//        return null;
//    }

    private static void register(Scanner scanner, IDataBaseConnection dbConnection) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter account type (admin/client): ");
        String accountType = scanner.nextLine();

        try {
            dbConnection.addUser(username, password, accountType);
            System.out.println("Registration successful.");
        } catch (SQLException e) {
            System.err.println("Error during registration: " + e.getMessage());
        }
    }


    // TODO: 15.12.2023 ADMIN handle
//    private static void performAdminActions(Admin admin, Scanner scanner, IDataBaseConnection dbConnection) {
//        boolean continueAdminSession = true;
//
//        while (continueAdminSession) {
//            System.out.println("Admin Panel:");
//            System.out.println("1. Add New Product");
//            System.out.println("2. Update Product Price");
//            System.out.println("3. Delete Product");
//            System.out.println("4. List of User");
//            System.out.println("5. List of product");
//            System.out.println("4. Exit");
//            System.out.print("Choose an option: ");
//            int option = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (option) {
//                case 1:
//                    addNewProduct(scanner, dbConnection);
//                    break;
//                case 2:
//                    updateProductPrice(scanner, dbConnection);
//                    break;
//                case 3:
//                    deleteProduct(scanner, admin);
//                case 4:
//                    displayProducts(dbConnection);
//                case 5:
//
//
//                case 6:
//                    continueAdminSession = false;
//                    break;
//                default:
//                    System.out.println("Invalid option.");
//                    break;
//            }
//        }
//    }
//    private static void addNewProduct(Scanner scanner, IDataBaseConnection dbConnection) {
//        System.out.println("Enter product id");
//        int id = scanner.nextInt();
//        System.out.print("Enter product name: ");
//        String name = scanner.next();
//        System.out.print("Enter product price: ");
//        int price = scanner.nextInt();
//        System.out.print("Enter category ID: ");
//        int categoryId = scanner.nextInt();
//
//        try {
//            dbConnection.addProduct( id ,name, price);
//            System.out.println("Product added successfully.");
//        } catch (SQLException e) {
//            System.err.println("Error adding product: " + e.getMessage());
//        }
//    }
//    private static void deleteProduct(Scanner scanner, Admin admin) {
//        System.out.print("Enter the ID of the product to delete: ");
//        int productId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        admin.deleteProduct(productId);
//    }
//    private static void updateProductPrice(Scanner scanner, IDataBaseConnection dbConnection) {
//        System.out.print("Enter product ID to update price: ");
//        int productId = scanner.nextInt();
//        System.out.print("Enter new price: ");
//        double newPrice = scanner.nextDouble();
//
//        try {
//            dbConnection.updatePrice(productId, (int) newPrice);
//            System.out.println("Product price updated successfully.");
//        } catch (SQLException e) {
//            System.err.println("Error updating product price: " + e.getMessage());
//        }
//    }
//
//
//    // TODO: 15.12.2023 Client handle
//    private static void performClientActions(Client client, Scanner scanner, IDataBaseConnection dbConnection) {
//        boolean continueShopping = true;
//        Basket basket = new Basket();
//
//        while (continueShopping) {
//            System.out.println("1. View Products");
//            System.out.println("2. Add Product to Basket");
//            System.out.println("3. View Basket");
//            System.out.println("4. Place Order");
//            System.out.println("5. Exit");
//            System.out.print("Choose an option: ");
//            int option = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (option) {
//                case 1 -> displayProducts(dbConnection);
//                case 2 -> addProductToBasket(scanner, basket, dbConnection);
//                case 3 -> basket.displayBasket();
//                case 4 -> placeOrder(scanner, basket);
//                case 5 -> continueShopping = false;
//                default -> System.out.println("Invalid option.");
//            }
//        }
//    }
//    private static void addProductToBasket(Scanner scanner, Basket basket, IDataBaseConnection dbConnection) {
//        System.out.print("Enter the ID of the product to add to your basket: ");
//        int productId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        try {
//            Product product = dbConnection.getProductById(productId);
//            if (product != null) {
//                basket.addProduct(product);
//                System.out.println(product.getName() + " added to your basket.");
//            } else {
//                System.out.println("Product with ID " + productId + " not found.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error fetching product: " + e.getMessage());
//        }
//    }
//    private static void displayProducts(IDataBaseConnection dbConnection) {
//        try {
//            List<Product> products = dbConnection.getProducts();
//            if (products.isEmpty()) {
//                System.out.println("No products available.");
//                return;
//            }
//
//            System.out.println("Available Products:");
//            for (Product product : products) {
//                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: $" + product.getPrice());
//            }
//        } catch (SQLException e) {
//            System.err.println("Error fetching products: " + e.getMessage());
//        }
//    }
//    private static void placeOrder(Scanner scanner,  Basket basket) {
//        System.out.print("Enter delivery address: ");
//        String address = scanner.nextLine();
//        System.out.println("Choose payment method:\n 1.PayPal\n 2.Credit Card\n 3.Crypto");
//        int paymentChoice = scanner.nextInt();
//        PaymentContext paymentContext = new PaymentContext();
//
//        switch (paymentChoice) {
//            case 1:
//                paymentContext.setPaymentStrategy(new PayPal());
//                break;
//            case 2:
//                paymentContext.setPaymentStrategy(new CreditCardPayment());
//                break;
//            case 3:
//                paymentContext.setPaymentStrategy(new CryptoPayment());
//                break;
//            default:
//                System.out.println("Invalid payment method selected.");
//                return;
//        }
//
//        int amount =(int) basket.getTotalPrice();
//        paymentContext.executePayment(amount);
//
//        System.out.println("Order placed delivery to " +  address );
//        System.out.println("Total amount " + amount );
//    }
}


// TODO: 16.12.2023 Proxy pattern





interface IDataBaseConnection{
    void addUser(String name , String  password , String account_type) throws SQLException;
    String checkUser(String name , String password) throws SQLException;
    void addProduct(int product_id , String product_name, int price) throws SQLException;
    void updatePrice(int product_id , int new_price) throws  SQLException;
    void deleteProduct(int product_id) throws SQLException;
    List<Product>getProducts() throws SQLException;
    Product getProductById(int product_id) throws SQLException;
    List<Client> getClients() throws SQLException;

    boolean checkUserExists(String username) throws SQLException;


    Connection connection();
}
// TODO: 15.12.2023 Single


class   DatabaseConnection implements IDataBaseConnection{
    private static DatabaseConnection instance;
    private final Connection connection;
    private DatabaseConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5431/ar", "postgres", "olzhas202");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseConnection getInstance(){
        if(instance == null)
            instance = new DatabaseConnection();
        return instance;
    }




    // TODO: 15.12.2023  adding user to db
    @Override
    public void addUser(String name ,String password , String account_type) throws SQLException{
        try (PreparedStatement statement = connection.prepareStatement("insert into users(user_name , password  , account_type) values(?,?,?)")){
            statement.setString(1 , name);
            statement.setString(2 , password);
            statement.setString(3 , account_type);

            statement.executeUpdate();
        }
    }

    // TODO: 15.12.2023  check user from db
    @Override
    public String checkUser(String user_name, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE user_name = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user_name);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("account_type");
                } else {
                    return null;
                }
            }
        }
    }



    // TODO: 15.12.2023  admin here should add product
    @Override
    public void addProduct(int product_id , String product_name , int price) throws  SQLException{
        String query = "insert into products(product_id , product_name , product_price ) values(?, ?, ?  )";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt( 1, product_id);
            statement.setString(2 , product_name);
            statement.setInt(3  , price);

            statement.executeUpdate();

        }
    }

    // TODO: 15.12.2023 update price of products
    @Override
    public void updatePrice(int product_id , int new_price) throws SQLException{
        String query = "update products set product_price = ? where product_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,new_price);
            statement.setInt(2 , product_id);
            int affectedrow = statement.executeUpdate();
            if(affectedrow == 0)
                throw  new SQLException("Updating failed , no rows affected");
        }
    }


    // TODO: 15.12.2023 get product list
    @Override
    public List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                products.add(new Product(id, name, (int) price));
            }
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("product_name");
                    double price = resultSet.getDouble("product_price");
                    return new Product(productId, name, (int)price);
                }
            }
        }
        return null;
    }

    // TODO: 15.12.2023 Delete product by id
    @Override
    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        }
    }

    public List<Client> getClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM users WHERE account_type = 'client'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString("user_name");
                clients.add(new Client(name));
            }
        }
        return clients;
    }

    @Override
    public Connection connection() {
        return connection;
    }

    @Override

    public boolean checkUserExists(String username) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE user_name = ?";
         // Get the connection from the proxy
            try (
                PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
            stmt.setString(1, username);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }


}

class DataBaseConnectionProxy implements IDataBaseConnection{
    private DatabaseConnection getRealConnnection(){
        return DatabaseConnection.getInstance();
    }

    @Override
    public void addUser(String name, String password, String account_type) throws SQLException {
        getRealConnnection().addUser(name , password , account_type );

    }

    @Override
    public String checkUser(String name, String password) throws SQLException {
        return getRealConnnection().checkUser(name , password);
    }

    @Override
    public void addProduct(int product_id, String product_name, int price) throws SQLException {
        getRealConnnection().addProduct(product_id , product_name , price);
    }

    @Override
    public void updatePrice(int product_id, int new_price) throws SQLException {
        getRealConnnection().updatePrice(product_id , new_price);

    }

    @Override
    public void deleteProduct(int product_id) throws SQLException {
        getRealConnnection().deleteProduct(product_id);

    }

    @Override
    public List<Product> getProducts() throws SQLException {
        return getRealConnnection().getProducts();
    }

    @Override
    public Product getProductById(int product_id) throws SQLException {
        return getRealConnnection().getProductById(product_id);
    }
    @Override
    public List<Client> getClients() throws SQLException {
        return getRealConnnection().getClients();
    }

    @Override
    public Connection connection() {
        return connection();
    }

    @Override
    public boolean checkUserExists(String username) throws SQLException {
        return getRealConnnection().checkUserExists(username);
    }

    public Connection getConnection() throws SQLException {

        return getRealConnnection().connection();
    }



}




// TODO: 15.12.2023 Factory pattern
abstract class UserAccount{
    protected String name;
    public UserAccount(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}




class Admin extends UserAccount{

    public Admin(String name) {
        super(name);
    }


//
//
//    public void addProduct(int product_id , String product_name , int price , int category_id){
//        try {
//            DatabaseConnection.getInstance().addProduct(product_id , product_name , price);
//        } catch (SQLException e) {
//            System.err.println("Error adding product " + e.getSQLState());
//        }
//    }
//
//    public void updateProductPrice(int product_id , int new_price){
//        try {
//            DatabaseConnection.getInstance().updatePrice(product_id , new_price);
//            System.out.println("Product price updated successfully");
//        } catch (SQLException e) {
//            System.err.println("Error updating process " + e.getMessage());
//        }
//    }
//    public void deleteProduct(int productId) {
//        try {
//            DatabaseConnection.getInstance().deleteProduct(productId);
//            System.out.println("Product deleted successfully.");
//        } catch (SQLException e) {
//            System.err.println("Error deleting product: " + e.getMessage());
//        }
//    }
//    public void displayProducts(IDataBaseConnection dbConnection) {
//        try {
//            List<Product> products = dbConnection.getProducts();
//            // ... code to display products ...
//        } catch (SQLException e) {
//            System.err.println("Error fetching products: " + e.getMessage());
//        }
//    }
//
//
//    public void displayClients(IDataBaseConnection dbConnection) {
//        try {
//            List<Client> clients = dbConnection.getClients();
//            if (clients.isEmpty()) {
//                System.out.println("No clients are registered.");
//            } else {
//                System.out.println("List of Clients:");
//                for (Client client : clients) {
//                    System.out.println("Client Name: " + client.getName());
//                    // Additional client details can be displayed here if available
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("Error fetching clients: " + e.getMessage());
//        }
//    }


}
class Client extends UserAccount{

    public Client(String name) {
        super(name);
    }

}


// TODO: 15.12.2023 Strategy pattern
interface Payment {
    void pay(double amount);
}
class PayPal implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment " + amount + " $");

    }
}
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing CreditCard payment " + amount + " $");

    }
}
class CryptoPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Crypto payment " + amount + " $");

    }
}
class PaymentContext{
    private Payment paymentStrategy;
    public PaymentContext(){}
    public PaymentContext(Payment paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(Payment paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }



    public void executePayment(double amount){
        if(paymentStrategy == null)
            throw  new IllegalArgumentException("Payment method has not been set");
    }
}

class Product{
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }


}
class Basket {
    private final List<Product> products;
    private int totalPrice;

    public Basket() {
        this.products = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }



    public List<Product> getProducts() {
        return products;
    }
    public void clear() {
        products.clear();
    }




}


