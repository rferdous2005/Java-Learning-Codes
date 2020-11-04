public class ReverseCounter extends BaseClass implements Runnable {
    String objectName;
    public ReverseCounter(String name) {
        this.objectName = name;
    }

    @Override
    public void run() {
        this.baseClassMethod();
        for(int i=10; i>=1; i--) {
            System.out.println(this.objectName+": "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
