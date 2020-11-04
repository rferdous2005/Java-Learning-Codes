
import java.io.*;

public class ObjectStreams {
    ObjectInputStream ois;

    ObjectOutputStream oos;


    public ObjectStreams() {

        try {
            this.oos = new ObjectOutputStream( new FileOutputStream("object_file.xyz") );

            this.ois = new ObjectInputStream( new FileInputStream("object_file.xyz"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObj() {
        // creating some objects
        Student s1 = new Student(1, "Ferdous", 27, 72);
        Student s2 = new Student(2, "Mahmud", 23, 65);

        Manager m1 = new Manager();
        Manager m2 = new Manager();

        try {
            // write the objects as bytes/binary data to a file using ObjectOutputStream in a specific sequence
            this.oos.writeObject(s1);
            this.oos.writeObject(m1);

            this.oos.writeObject(s2);
            this.oos.writeObject(m2);

            this.oos.close();

            // Then reading those objects from previously stored file according to insertion order
            // It will throw ugly exceptions if we dont follow insertion order
            // Remember to implement Serializable

            for(int i=0; i < 10; i++) {
                Student s = (Student) this.ois.readObject();
                Manager m = (Manager) this.ois.readObject();

                System.out.println(s.toString());
                m.callForMeeting();

            }
            this.ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
