public class MainClass {
    public static void main(String[] args) {
        Counter counter = new Counter("Forward counter");
        counter.start();

        try {
            counter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ReverseCounter reverseCounter = new ReverseCounter("Reverse Counter", counter);
        reverseCounter.start();

        try {
            reverseCounter.join(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread execution finished");
    }
}
