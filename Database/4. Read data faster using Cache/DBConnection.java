import java.sql.*;
import java.util.HashMap;

public class DBConnection {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private HashMap<Integer, Customer> customerCache = new HashMap<>();

    private final String url = "jdbc:mysql://127.0.0.1/db_with_java?useSSL=false&allowPublicKeyRetrieval=true";
    private final String username = "demo_select_only";
    private final String password = "demo@Select123";

    public Connection getConnection() {
        Connection con= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password); // demo@Select123
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void getCustomerInfoById(int id) throws SQLException {
        this.connection = this.getConnection();
        this.preparedStatement = this.connection.prepareStatement(
                "select * from customer where id = ? ");

        this.preparedStatement.setInt(1, id);
        this.resultSet = this.preparedStatement.executeQuery();

        while(resultSet.next()) {
            System.out.println("Name: " + this.resultSet.getString("name"));
            System.out.println("Contact: " + this.resultSet.getString("contact"));
            System.out.println("Last purchase: " + this.resultSet.getString("last_purchase"));
            System.out.println("===========================================================");
        }

        this.resultSet.close();
        this.connection.close();
        this.preparedStatement.close();
    }

    public void saveAllCustomersIntoCache() throws SQLException {
        this.connection = this.getConnection();
        this.preparedStatement = this.connection.prepareStatement(
                "select * from customer");

        this.resultSet = this.preparedStatement.executeQuery();

        while(resultSet.next()) {
            Customer customer = new Customer();
            int id;
            customer.setName(resultSet.getString("name"));
            customer.setContact(resultSet.getString("contact"));
            customer.setLastPurchase(resultSet.getString("last_purchase"));
            id = resultSet.getInt("id");

            customerCache.put(id, customer);
        }

        this.resultSet.close();
        this.connection.close();
        this.preparedStatement.close();
    }

    public void usingNoCache() throws SQLException {

        System.out.println("Using No-Cache");
        long startTime = System.currentTimeMillis();
        for(int n=1; n < 10; n++) {
            this.getCustomerInfoById(n);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Total time: "+ (endTime-startTime)+" ms");
    }

    public void usingCache() throws SQLException {
        System.out.println("Using Cache");

        long startTime = System.currentTimeMillis();
        if(customerCache.isEmpty()) {
            this.saveAllCustomersIntoCache();
        }

        for(int i=1; i<10; i++) {
            Customer customer = this.customerCache.get(i);
            if(customer == null) {
                continue;
            }

            System.out.println("Name: " + customer.getName());
            System.out.println("Contact: " + customer.getContact());
            System.out.println("Last purchase: " + customer.getLastPurchase());
            System.out.println("===========================================================");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time: "+ (endTime-startTime)+" ms");

    }











}
