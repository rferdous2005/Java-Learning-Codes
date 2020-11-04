import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Distributor extends Thread {
    LinkedBlockingQueue<FoodOrder> ordersQueue;
    ReentrantLock monitor;

    public Distributor(ReentrantLock m, int id, LinkedBlockingQueue<FoodOrder> orders) {
        this.ordersQueue = orders;
        this.setName("Distributor "+ id);
        monitor = m;
    }

    public void run() {
        int c=0;
        while(true) {
            if(c>0) {
                System.out.println("Distributor Loop running after getting Notified.");
            }
            if(ordersQueue.isEmpty()) {
                System.out.println(this.getName()+ " finds Q empty!!");
            }

            try {
                FoodOrder currentOrder = ordersQueue.take(); // waiting until elements are available in Q
                if(currentOrder.getStatus().equals("COOKED")) {
                    this.findDeliveryMan(currentOrder);
                    System.out.println(this.getName()+": Cooking Finished");

                } else {
                    ordersQueue.put(currentOrder);
                    System.out.println(this.getName()+": goes to wait()");
                    synchronized (monitor) {
                        monitor.wait();
                    }
                }
                c++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void findDeliveryMan(FoodOrder currentOrder) {
        System.out.println(this.getName()+": Order "+currentOrder.getId()+" is on the way");
    }
}
