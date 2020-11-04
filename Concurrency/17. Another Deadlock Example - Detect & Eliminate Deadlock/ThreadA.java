public class ThreadA extends Thread {
    public void run() {
        try {
            System.out.println("A Waiting/ sleeping until B is finished execution");
            Main.b.join();
            System.out.println("To be executed after join on A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
