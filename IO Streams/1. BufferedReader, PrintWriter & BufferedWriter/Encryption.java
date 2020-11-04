
import java.io.*;

public class Encryption extends Thread {
    FileReader fileReader;
    FileWriter fileWriter;

    BufferedReader br;
    PrintWriter pw;

    BufferedWriter bw;

    public Encryption(String fileName) {
        try {
            this.fileReader = new FileReader("original_files/"+fileName);
            this.fileWriter = new FileWriter("encrypted_files/"+fileName);

            this.br = new BufferedReader(this.fileReader);
            this.pw = new PrintWriter(new BufferedWriter(this.fileWriter));

        } catch (IOException e) {
            System.out.println("Specified File not found!");
        }
    }

    @Override
    public void run() {
        String line;
        try{
            while ((line = this.br.readLine())!= null) {
                long start = System.nanoTime();
                this.pw.println(line.toUpperCase());
                this.pw.println(line.toUpperCase());
                this.pw.println(line.toUpperCase());
                long end = System.nanoTime();

                System.out.println((end-start));

//                this.pw.write(line);
//                this.pw.write(line);
//                this.pw.write(line);

            }
            this.br.close();
            this.pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

