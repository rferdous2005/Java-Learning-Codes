import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName;
        while(true) {
            System.out.print("Enter file name: ");
            fileName = input.nextLine();

            ByteStreams fileEncryption = new ByteStreams(fileName);
            fileEncryption.start();
        }
    }
}
