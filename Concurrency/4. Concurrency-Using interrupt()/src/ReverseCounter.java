public class ReverseCounter extends Thread {
    String objectName;
    Counter c;
    public ReverseCounter(String name, Counter counter) {
        this.objectName = name;
        this.c = counter;
    }

    @Override
    public void run() {
        for(int i=10; i>=1; i--) {
            System.out.println(this.objectName+": "+ i);

            if(this.isInterrupted()) {
                System.out.println(Thread.currentThread().getName()+ ": I am interrupted");
                System.out.println("So, countdown off. And I will interrupt the forward counter..");
                this.c.interrupt();
                break;
            }
        }
    }
}
