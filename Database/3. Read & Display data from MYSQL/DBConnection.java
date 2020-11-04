import java.sql.*;

public class DBConnection {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

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

    public void insertCustomer() throws SQLException {
        this.connection = this.getConnection();
        this.preparedStatement = this.connection.prepareStatement(
                "INSERT INTO customer (name, contact, last_purchase) VALUES (?, ?, NOW())");

        this.preparedStatement.setString(1, "Tahmid Ferdous");
        this.preparedStatement.setString(2, "01985754530");
        int affectedRows = this.preparedStatement.executeUpdate();
        System.out.println(affectedRows+" inserted into database");

        this.connection.close();
        this.preparedStatement.close();

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
            System.out.println("Last purchase Date: " + this.resultSet.getString("last_purchase"));
            System.out.println("===========================================================");
        }

        this.resultSet.close();
        this.connection.close();
        this.preparedStatement.close();
    }















}
