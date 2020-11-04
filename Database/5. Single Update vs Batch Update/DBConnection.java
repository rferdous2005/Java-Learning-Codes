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

    public void singleUpdate() throws SQLException {
        System.out.println("Using single update");
        long startTime = System.currentTimeMillis();
        for(int n=1; n< 10; n++) {
            this.connection = this.getConnection();
            this.preparedStatement = this.connection.prepareStatement(
                    "UPDATE customer SET last_purchase = NOW() WHERE id= ? ");
            this.preparedStatement.setInt(1, n);
            this.preparedStatement.executeUpdate();

            this.connection.close();
            this.preparedStatement.close();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time: "+(endTime-startTime)+ " ms");
    }

    public void batchUpdate() throws SQLException {
        System.out.println("Using batch update");
        long startTime = System.currentTimeMillis();
        this.connection = this.getConnection();
        this.preparedStatement = this.connection.prepareStatement(
                    "UPDATE customer SET last_purchase = NOW() WHERE id>=1 AND id <10 ");

        this.preparedStatement.executeUpdate();

        this.connection.close();
        this.preparedStatement.close();

        long endTime = System.currentTimeMillis();
        System.out.println("Total time: "+(endTime-startTime)+ " ms");
    }














}
