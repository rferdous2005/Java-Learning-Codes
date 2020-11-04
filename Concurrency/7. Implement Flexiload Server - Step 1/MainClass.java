import java.sql.SQLException;

public class MainClass {

    public static void main(String[] args) {
        Flexiload flexiload = new Flexiload();
        try {
            while(true) {
                flexiload.executeFlexiloadRequests();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
