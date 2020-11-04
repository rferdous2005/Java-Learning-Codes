
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryption extends Thread {
    FileReader fileReader;
    FileWriter fileWriter;

    public Encryption(String fileName) {
        try {
            this.fileReader = new FileReader("original_files/"+fileName);
            this.fileWriter = new FileWriter("encrypted_files/"+fileName);
        } catch (IOException e) {
            System.out.println("Specified File not found!");
        }
    }

    @Override
    public void run() {
        try {
            int currentLetter;
            // loop for iterating every character of the file
            while ((currentLetter=fileReader.read())!= -1) {
                // logic for replacing the character with the next character
                if(currentLetter == 'z') {
                    fileWriter.append('a');
                } else if(currentLetter == 'Z') {
                    fileWriter.append('A');
                } else if(currentLetter == '\r' || currentLetter == '\n'|| currentLetter == ' ') {
                    fileWriter.append((char) currentLetter);
                } else {
                    fileWriter.append((char)(currentLetter+1));
                }
            }

            this.fileWriter.close();
            this.fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
