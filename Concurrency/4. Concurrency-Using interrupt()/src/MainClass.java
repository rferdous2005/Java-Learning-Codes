public class MainClass {

    public static void main(String[] args) {
        Counter counter = new Counter("Forward counter");
        counter.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Uncomment the following line for experiment
        // counter.interrupt();

        ReverseCounter reverseCounter = new ReverseCounter("Reverse Counter", counter);
        reverseCounter.start();

        reverseCounter.interrupt();
    }
}
