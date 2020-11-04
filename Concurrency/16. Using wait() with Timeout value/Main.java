import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Main{

    public static void main(String[] args) {

        LinkedBlockingQueue<FoodOrder> ordersQueue = new LinkedBlockingQueue<>();
        ReentrantLock monitor = new ReentrantLock();
        for(int i=0; i < 10; i++) {
            try {
                ordersQueue.put(new FoodOrder(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            new OrderProcessor(monitor, ordersQueue).start();

            for(int i=0; i<25; i++) {
                new Distributor(monitor, i, ordersQueue).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
