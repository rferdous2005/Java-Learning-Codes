public class ThreadB extends Thread {
    public void run() {
        try {
            System.out.println("B Waiting/ sleeping until A is finished execution");
            Main.a.join(5000);
            System.out.println("To be executed after join on B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
