

public class Main{
    static Thread a = new ThreadA();
    static ThreadB b = new ThreadB();

    public static void main(String[] args) {


        a.start();

        b.start();

    }
}
