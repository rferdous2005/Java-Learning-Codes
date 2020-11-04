
import java.io.*;

public class Assignments {
    File f;


    public Assignments() throws IOException {
        // Explore all methods of File class

        this.f = new File("IO Stream.iml");

        System.out.println(this.f.getTotalSpace()+" bytes");
        System.out.println(this.f.isDirectory() + " "+ this.f.isFile());

        // Explore DataInputStream & DataOutputStream, their most useful methods
        // to read and write files
        // chain FileInputStream & FileOutputStreams respectively with these
        // do your own research. its easy!!

    }

}
