
import java.io.*;

public class ByteStreams extends Thread {
    FileInputStream fis;
    FileOutputStream fos;

    BufferedInputStream bis;
    BufferedOutputStream bos;

    public ByteStreams(String fileName) {
        try {
            this.fis = new FileInputStream("./"+fileName);
            this.fos = new FileOutputStream("./Copy_of_"+fileName);

            this.bis = new BufferedInputStream(new FileInputStream("./"+fileName), 40960);
            this.bos = new BufferedOutputStream(new FileOutputStream("./Copy_buffered_"+fileName), 40960);

        } catch (IOException e) {
            System.out.println("Specified File not found!");
        }
    }

    @Override
    public void run() {
        int singleByte;
        try {
            long start = System.currentTimeMillis();

            while((singleByte = this.fis.read()) != -1) {
                // we can do any operation/ modification on singleByte individually

                this.fos.write(singleByte);
            }

            long end = System.currentTimeMillis();
            System.out.println("File I/O: "+ (end-start));

            start = System.currentTimeMillis();

            while((singleByte = this.bis.read()) != -1) {
                // we can do any operation/ modification on singleByte individually

                this.bos.write(singleByte);
            }

            end = System.currentTimeMillis();
            System.out.println("Buffered I/O: "+ (end-start));

            this.fis.close();
            this.fos.close();

            this.bis.close();
            this.bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
