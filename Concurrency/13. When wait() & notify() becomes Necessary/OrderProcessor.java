import java.io.*;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderProcessor extends Thread {
    Random random = new Random();
    LinkedBlockingQueue<FoodOrder> ordersQueue;

    public OrderProcessor(LinkedBlockingQueue<FoodOrder> orders) throws IOException {
        this.ordersQueue = orders;
    }
    public void run() {
        for( ; ; ) {
            int delayTime = random.nextInt(500) + 1000; // from 1 to 1.5 sec
            try {
                Thread.sleep(delayTime);
                this.changeStatus();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void changeStatus() throws InterruptedException {
        FoodOrder order = ordersQueue.take(); // waiting until elements are available in Q
        switch (order.getStatus()) {
            case "ARRIVED":
                order.setStatus("PROCESSING");
                System.out.println("Order "+ order.getId()+ " to PROCSSING");
                break;
            case "PROCESSING":
                order.setStatus("COOKING");
                System.out.println("Order "+ order.getId()+ " to COOKING");
                break;
            case "COOKING":
                order.setStatus("COOKED");
                System.out.println("Order "+ order.getId()+ " to COOKED");
                break;
        }
        ordersQueue.put(order);
    }
}
