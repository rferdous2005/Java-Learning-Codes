import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Distributor extends Thread {
    LinkedBlockingQueue<FoodOrder> ordersQueue;

    public Distributor(int distributorId, LinkedBlockingQueue<FoodOrder> orders) throws IOException {
        this.ordersQueue = orders;
        this.setName("Distributor "+ distributorId);
    }

    public void run() {
        while(true) {
            if(ordersQueue.isEmpty()) {
                System.out.println(this.getName() + " finds order Q empty!");
            }
            try {
                FoodOrder currentOrder = ordersQueue.take(); // waiting until elements are available in Q
                if(currentOrder.getStatus().equals("COOKED")) {
                    this.findDeliveryMan(currentOrder);
                    System.out.println(this.getName()+": Cooking Finished.");
                } else {
                    ordersQueue.put(currentOrder);
                    System.out.println(this.getName()+": Not cooked yet. Putting back to Q..");
                    //Thread.sleep(500);
                    //System.out.println(this.getName()+ " is sleeping");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean findDeliveryMan(FoodOrder order) throws InterruptedException {
        System.out.println(this.getName()+": Order "+order.getId()+" is on the way...");
        return true;
    }
}
