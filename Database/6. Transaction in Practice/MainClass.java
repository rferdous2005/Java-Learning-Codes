import java.sql.SQLException;

public class MainClass {

    public static void main(String[] args) {
        DBConnection dbApp = new DBConnection();

        try {
            dbApp.placeOrderTransaction(8, 50);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
