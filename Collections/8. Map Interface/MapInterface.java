import java.util.*;

public class MapInterface {

    public void execute() {
        HashMap<Student, String> hashMap = new HashMap<>();

        Student s1 = new Student(105, "Mim", 26, 65);
        hashMap.put(s1, "b-01");

        Student s2 = new Student(101, "Shahin", 22, 75);
        hashMap.put(s2, "b-02");

        Student s3 = new Student(103, "Ferdous", 25, 80);
        hashMap.put(s3, "b-02");

        Student s5 = new Student(103, "Ferdous", 25, 80);
        hashMap.put(s5, "b-03");

        Student s4 = new Student(102, "Afra", 19, 80);
        hashMap.put(s4, "b-02");

        hashMap.put(null, "b-01");

        Student searchStudent = new Student(103, "Ferdous", 25, 80);
        System.out.println("Student found: "+ hashMap.containsKey(searchStudent));

        System.out.println("HashMap");
        for(Student std : hashMap.keySet()) {
            System.out.println(std);
            System.out.println(hashMap.get(std));
            System.out.println();
        }

    }
}
