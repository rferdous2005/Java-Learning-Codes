import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class OrderProcessor extends Thread {
    Random random = new Random();
    LinkedBlockingQueue<FoodOrder> ordersQueue;

    ReentrantLock monitor;
    public OrderProcessor(ReentrantLock m, LinkedBlockingQueue<FoodOrder> orders) {
        this.ordersQueue = orders;
        monitor = m;
    }

    public void run() {
        for( ; ; ) {
            int delayTime = random.nextInt(1000)+500; // from .5 to 1.5 sec

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

        switch(order.getStatus()) {
            case "ARRIVED":
                order.setStatus("PROCESSING");
                System.out.println("Order "+order.getId()+ " to Processing");
                ordersQueue.put(order);
                break;
            case "PROCESSING":
                order.setStatus("COOKING");
                System.out.println("Order "+order.getId()+ " to Cooking");
                ordersQueue.put(order);
                break;
            case "COOKING":
                order.setStatus("COOKED");
                System.out.println("Order "+order.getId()+ " to Cooked");
                ordersQueue.put(order);
                System.out.println("Processor notifying Distributor");
                synchronized (monitor) {
                    monitor.notifyAll();
                }
                break;
            case "COOKED":
                ordersQueue.put(order);
        }






    }












}
