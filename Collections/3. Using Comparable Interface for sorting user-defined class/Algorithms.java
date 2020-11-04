import java.util.*;

public class Algorithms {

    public void execute() {
        List<Student> list = new ArrayList<>();
        Random random = new Random();

        Student s1 = new Student(105, "Mim", 26, 80);
        list.add(s1);

        Student s2 = new Student(101, "Shahin", 22, 80);
        list.add(s2);

        Student s3 = new Student(103, "Ferdous", 25, 80);
        list.add(s3);

        Student s4 = new Student(102, "Afra", 19, 80);
        list.add(s4);

        System.out.println(list);


        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list);

    }
}
