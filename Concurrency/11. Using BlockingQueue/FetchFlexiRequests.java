import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class FetchFlexiRequests extends Thread {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    int fetchSize = 5000;
    int processingBatch = 500;
    BlockingQueue<FlexiloadInfo> Q;

    public FetchFlexiRequests(BlockingQueue<FlexiloadInfo> Q) {
        this.Q = Q;
    }

    @Override
    public void run() {
        while(true) {
            try {
                this.pickFromDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void pickFromDB() throws SQLException {
        System.out.println("Operation starts...");
        this.connection = DBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement("SELECT * from flexiload_requests " +
                " WHERE `Status`='New'");
        this.preparedStatement.setFetchSize(this.fetchSize);
        this.resultSet = this.preparedStatement.executeQuery();

        List<Integer> idList = new ArrayList<>();
        List<FlexiloadInfo> flexiBatch = new ArrayList<>();

        while(this.resultSet.next()) {
            FlexiloadInfo flexiloadInfo = new FlexiloadInfo();

            flexiloadInfo.setId(resultSet.getInt("id"));
            flexiloadInfo.setSender(resultSet.getString("Sender"));
            flexiloadInfo.setReceiver(resultSet.getString("Receiver"));
            flexiloadInfo.setAmount(resultSet.getInt("Amount"));

            idList.add(flexiloadInfo.getId());
            flexiBatch.add(flexiloadInfo);

            if(idList.size() == processingBatch) {
                this.makeStatusProcessing(idList);

                Q.addAll(flexiBatch);

                idList.clear();
                flexiBatch.clear();
            }
        }

        this.connection.close();
        this.resultSet.close();
        this.preparedStatement.close();
    }

    public void makeStatusProcessing(List<Integer> idList) {
        String sqlids = idList.toString();

        sqlids = sqlids.replace('[', '(');
        sqlids = sqlids.replace(']', ')');

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE flexiload_requests " +
                    " SET `Status`= ?, updated_at= NOW() WHERE id IN "+ sqlids);
            preparedStatement.setString(1, "Processing");
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

















}
