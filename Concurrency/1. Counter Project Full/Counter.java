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
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Counter("Forward Counter 1").start();
        new Counter("Forward Counter 2").start();
        new ReverseCounter("Reverse Counter 1").start();
        new ReverseCounter("Reverse Counter 2").start();

        /* Creating Counter threads inside loop
        for(int i=1; i<=20; i++) {
            Counter counter = new Counter("Forward Counter "+ i);
            counter.start();
        }
        */
        /* Creating ReverseCounter threads inside loop
        for(int i=1; i<=30; i++) {
            ReverseCounter reverseCounter = new ReverseCounter("Reverse Counter "+ i);
            reverseCounter.start();
        }
        */

        for(int i=1; i<=10; i++) {
            System.out.println("Main method: "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
