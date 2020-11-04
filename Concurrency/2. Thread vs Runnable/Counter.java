public class Counter extends Thread {
    private String objectName;
    public Counter(String name) {
        this.objectName = name;
    }

//    @Override
//    public void run() {
//        for(int i=10; i>=1; i--) {
//            System.out.println(this.objectName+": "+ i);
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
        Counter counter = new Counter("Forward Counter ");
        counter.start();

        Runnable reverseCounter = new ReverseCounter("Reverse Counter ");
//        Thread rcThread = new Thread(reverseCounter);
//        rcThread.start();
        new Thread(reverseCounter).start();

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
