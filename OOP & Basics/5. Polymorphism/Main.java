import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Main app = new Main();
        for(int i=0; i < 20; i++) {
            TVSerial serial = getTVSerial();

            System.out.println(serial.getPlot());
            System.out.println();
        }

    }

    public static TVSerial getTVSerial() {
        int randomNumber = new Random().nextInt();
        randomNumber = randomNumber % 5;
        System.out.println(randomNumber);

        switch (randomNumber) {
            case 0:
                return new BreakingBad();

            case 1:
                return new WalkingDead();

            case 2:
                return new Dark();

            case 3:
                return new Dexter();

            case 4:
                return new GameOfThrones();
        }
        return new Dexter();
    }
}
