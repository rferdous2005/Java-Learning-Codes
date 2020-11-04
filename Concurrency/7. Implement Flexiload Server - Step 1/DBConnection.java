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

}
