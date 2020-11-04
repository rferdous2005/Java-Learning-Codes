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
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /* Uncomment this block for experiment
            if(i == 9) {
                try {
                    c.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            */
        }
    }
}
