import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

    public static void main(String[] args) {
        BlockingQueue<FlexiloadInfo> Q = new LinkedBlockingQueue<>();
        int threadNo = 300;

        new FetchFlexiRequests(Q).start();

        for(int i=0; i< threadNo; i++) {
            new ExecuteSingleFlexiRequest(Q).start();
        }
    }
}
