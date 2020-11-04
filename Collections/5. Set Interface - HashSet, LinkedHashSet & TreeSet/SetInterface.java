import java.util.*;

public class SetInterface {

    public void execute() {
        HashSet<Student> hashSet = new HashSet<>();

        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();

        TreeSet<Student> treeSet = new TreeSet<>();

        Student s1 = new Student(105, "Mim", 26, 69);
        hashSet.add(s1);
        linkedHashSet.add(s1);
        treeSet.add(s1);

        Student s2 = new Student(101, "Shahin", 22, 75);
        hashSet.add(s2);
        linkedHashSet.add(s2);
        treeSet.add(s2);

        Student s3 = new Student(103, "Ferdous", 25, 80);
        hashSet.add(s3);
        linkedHashSet.add(s3);
        treeSet.add(s3);

        Student s4 = new Student(102, "Afra", 19, 80);
        hashSet.add(s4);
        linkedHashSet.add(s4);
        treeSet.add(s4);

        hashSet.add(null);
        linkedHashSet.add(null);
        
//        treeSet.add(null);

//        hashSet.clear();
//        linkedHashSet.clear();
//        treeSet.clear();

//        clear() method can be used in any type of collection. List, Map etc..
//        Method Works in the very same way

        System.out.println(hashSet);

        System.out.println(linkedHashSet);

        System.out.println(treeSet);

    }
}
