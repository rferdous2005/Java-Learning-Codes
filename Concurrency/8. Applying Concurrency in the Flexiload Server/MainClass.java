import java.util.LinkedList;
import java.util.Queue;

public class MainClass {

    public static void main(String[] args) {
        Queue<FlexiloadInfo> Q = new LinkedList<>();
        int threadNo = 100;

        new FetchFlexiRequests(Q).start();

        for(int i=0; i< threadNo; i++) {
            new ExecuteSingleFlexiRequest(Q).start();
        }
    }
}
