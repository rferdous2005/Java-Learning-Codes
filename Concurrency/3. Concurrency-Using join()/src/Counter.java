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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
