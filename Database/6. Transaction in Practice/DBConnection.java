import java.sql.*;

public class DBConnection {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    private final String url = "jdbc:mysql://127.0.0.1/db_with_java?useSSL=false&allowPublicKeyRetrieval=true";
    private final String username = "root";
    private final String password = "root";

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

    public void placeOrderTransaction(int customerId, int amount) throws SQLException {
        this.connection = this.getConnection();
        this.connection.setAutoCommit(false);

        this.preparedStatement = this.connection.prepareStatement(
                "INSERT INTO orders (amount, customer_id) VALUES (?, ?) ");
        this.preparedStatement.setInt(1, amount);
        this.preparedStatement.setInt(2, customerId);

        this.preparedStatement.executeUpdate();
        try {
            this.preparedStatement = this.connection.prepareStatement("UPDATE customer SET " +
                    "credit = credit - ? WHERE id = ? ");
            this.preparedStatement.setInt(1, amount);
            this.preparedStatement.setInt(2, customerId);

            this.preparedStatement.executeUpdate();
            this.connection.commit();

            System.out.println("Order inserted!");
        } catch(Exception e) {
            this.connection.rollback();

            e.printStackTrace();
        }



        this.connection.close();
        this.preparedStatement.close();
    }














}
