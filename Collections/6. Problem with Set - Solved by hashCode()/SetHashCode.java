import java.util.*;

public class SetHashCode {

    public void execute() {

        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();

        Student s1 = new Student(105, "Mim", 26, 69);
        linkedHashSet.add(s1);

        Student s2 = new Student(101, "Shahin", 22, 75);
        linkedHashSet.add(s2);

        Student s3 = new Student(103, "Ferdous", 25, 80);
        linkedHashSet.add(s3);

        Student s5 = new Student(103, "Ferdous", 25, 80);
        linkedHashSet.add(s5);

        Student s4 = new Student(102, "Afra", 19, 80);
        linkedHashSet.add(s4);

        linkedHashSet.add(null);

        Student searchStudent = new Student(103, "Ferdous", 25, 80);
        System.out.println("Student found: "+ linkedHashSet.contains(searchStudent));

        System.out.println(linkedHashSet);


    }
}
