
import java.io.*;

public class ByteStreams extends Thread {
    FileInputStream fis;
    FileOutputStream fos;

    public ByteStreams(String fileName) {
        try {
            this.fis = new FileInputStream("./"+fileName);
            this.fos = new FileOutputStream("./Copy_of_"+fileName);

        } catch (IOException e) {
            System.out.println("Specified File not found!");
        }
    }

    @Override
    public void run() {
        byte[] bytes = new byte[4096];
        try {
            //bytes = this.fis.readAllBytes();

            while(this.fis.read(bytes) != -1) {
                this.fos.write(bytes);
            }

            this.fis.close();
            this.fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
