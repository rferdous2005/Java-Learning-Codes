import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Flexiload {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    int fetchSize = 5000;

    public void executeFlexiloadRequests() throws SQLException {
        System.out.println("Starts operation ");
        this.connection = DBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement("SELECT * from flexiload_requests " +
                                    " WHERE `Status`= 'New'");
        this.preparedStatement.setFetchSize(this.fetchSize);
        this.resultSet = this.preparedStatement.executeQuery();

        while(this.resultSet.next()) {
            FlexiloadInfo flexiloadInfo = new FlexiloadInfo();

            flexiloadInfo.setId(resultSet.getInt("id"));
            flexiloadInfo.setSender(resultSet.getString("Sender"));
            flexiloadInfo.setReceiver(resultSet.getString("Receiver"));
            flexiloadInfo.setAmount(resultSet.getInt("Amount"));

            String flexiStatus = this.sendAmountTransaction(flexiloadInfo);

            flexiloadInfo.setStatus(flexiStatus);

            this.updateStatus(flexiloadInfo);
        }

        this.connection.close();
        this.resultSet.close();
        this.preparedStatement.close();
    }

    public String sendAmountTransaction(FlexiloadInfo flexiloadInfo) {
        // just applying some delay for the transaction

        try {
            Thread.sleep(new Random().nextInt(50)+50);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public boolean updateStatus(FlexiloadInfo flexiloadInfo) {

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE flexiload_requests " +
                    "SET `Status`= ?, updated_at= NOW() WHERE id = ? ");
            preparedStatement.setString(1, flexiloadInfo.getStatus());
            preparedStatement.setInt(2, flexiloadInfo.getId());
            preparedStatement.executeUpdate();
            connection.close();
            System.out.print(". ");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }















}
