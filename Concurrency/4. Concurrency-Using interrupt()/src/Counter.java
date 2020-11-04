public class Counter extends Thread {
    private String objectName;
    public Counter(String name) {
        this.objectName = name;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++) {
            System.out.println(this.objectName+": "+ i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+": I am interrupted");
                System.out.println("Now I can do other things. Shutting off countdown..");
                break;
                // interrupt signal comes here when this thread is in sleep, or join
                // We can do anything. We can apply any logic.
            }
        }
    }
}
