import java.sql.SQLException;

public class MainClass {

    public static void main(String[] args) {
        DBConnection dbApp = new DBConnection();

        try {
            //dbApp.insertCustomer();
            dbApp.getCustomerInfoById(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
