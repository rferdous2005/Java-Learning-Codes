import java.sql.SQLException;

public class MainClass {

    public static void main(String[] args) {
        DBConnection dbApp = new DBConnection();

        try {
            dbApp.usingNoCache();

            dbApp.usingCache();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
