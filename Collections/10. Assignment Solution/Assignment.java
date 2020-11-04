import java.util.*;

public class Assignment {

    String[] strings = {"MyString", "NewString", "AnotherString",
                        "Java", "Collections", "Stack", "Queue", "LinkedList",
                        "Examples", "Assignment"};
    public void execute() {
        Queue<String> q = new LinkedList<>();   // First In First Out

        Queue<String> pq = new PriorityQueue<>();   // Sorted ASC

        Stack<String> st = new Stack<>();   // First In Last Out/ Last In First Out

        for(String str: strings) {
            q.add(str);
            pq.add(str);
            st.push(str);
        }

        System.out.println("===== Queue =====");
        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }
        System.out.println();

        System.out.println("===== Priority Queue =====");
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        System.out.println();

        System.out.println("===== Stack =====");
        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }
        System.out.println();


    }
}
