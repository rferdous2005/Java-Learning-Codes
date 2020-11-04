import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class Main{
    public static void main(String[] args) {
        LinkedBlockingQueue<FoodOrder> ordersQueue = new LinkedBlockingQueue<>();
        for(int i=0; i < 10; i++) {
            try {
                ordersQueue.put(new FoodOrder(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            new OrderProcessor(ordersQueue).start();

            for(int i=0; i<25; i++) {
                new Distributor(i, ordersQueue).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
