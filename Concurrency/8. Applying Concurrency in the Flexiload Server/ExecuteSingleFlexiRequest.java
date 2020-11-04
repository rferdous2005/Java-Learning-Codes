import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Queue;
import java.util.Random;

public class ExecuteSingleFlexiRequest extends Thread {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    int fetchSize = 5000;
    Queue<FlexiloadInfo> Q;

    public  ExecuteSingleFlexiRequest(Queue<FlexiloadInfo> Q) {
        this.Q = Q;
    }

    @Override
    public void run() {
        while(true) {
            if(Q.isEmpty()) {
                try {
                    Thread.sleep(100);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            FlexiloadInfo flexiloadInfo = Q.poll();
            if(flexiloadInfo != null) {
                this.singleFlexiTransaction(flexiloadInfo);
            }
        }
    }

    public void singleFlexiTransaction(FlexiloadInfo flexiloadInfo) {
        String flexiStatus = this.sendAmountTransaction(flexiloadInfo);
        flexiloadInfo.setStatus(flexiStatus);

        this.updateStatus(flexiloadInfo);
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
        System.out.println(flexiloadInfo.getId()+" - "+flexiloadInfo.getStatus());
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE flexiload_requests " +
                    "SET `Status`= ?, updated_at= NOW() WHERE id = ? ");
            preparedStatement.setString(1, flexiloadInfo.getStatus());
            preparedStatement.setInt(2, flexiloadInfo.getId());
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }





















}
