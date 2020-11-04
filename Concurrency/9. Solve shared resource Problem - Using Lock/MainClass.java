import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

    public static void main(String[] args) {
        Queue<FlexiloadInfo> Q = new LinkedList<>();
        int threadNo = 100;
        ReentrantLock rlock = new ReentrantLock();

        new FetchFlexiRequests(Q, rlock).start();

        for(int i=0; i< threadNo; i++) {
            new ExecuteSingleFlexiRequest(Q, rlock).start();
        }
    }
}
