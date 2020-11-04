import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

    public static void main(String[] args) {
        Queue<FlexiloadInfo> Q = new LinkedList<>();
        int threadNo = 100;
        //ReentrantLock monitor = new ReentrantLock();

        Object monitor = new Object();
        new FetchFlexiRequests(Q, monitor).start();

        for(int i=0; i< threadNo; i++) {
            new ExecuteSingleFlexiRequest(Q, monitor).start();
        }
    }
}
