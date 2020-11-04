import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException {

        File directory = new File("original_files");
        FileWriter fileWriter = null;

        //fileWriter = new FileWriter("sequential_runtimes.txt", true); // for sequential operation
        fileWriter = new FileWriter("concurrent_runtimes.txt", true); // for concurrent operation

        if(directory.isDirectory()) {
            List<Encryption> threadObjects = new LinkedList<Encryption>();
            long startTime = System.currentTimeMillis();

            for(File file:directory.listFiles()) {
                Encryption encryption = new Encryption(file.getName());
                //encryption.run(); // for sequential operation
                encryption.start(); // for concurrent operation
                threadObjects.add(encryption);
            }

            for(Encryption enc: threadObjects) {
                try {
                    enc.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Encryption Complete!");
            fileWriter.write((endTime-startTime)/1000.0+"\n");
            fileWriter.close();
        }
    }
}
