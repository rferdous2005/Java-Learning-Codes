import java.util.*;

public class Unmodifiables {
    List<String> list = new LinkedList<>();

    Map<String, Integer> map = new HashMap<>();

    String[] strings = {"MyString", "NewString", "AnotherString",
                        "Java", "Collections", "Stack", "Queue", "LinkedList",
                        "Examples", "Assignment"};
    public void readAndWrite() {

        // write once and then make unmodifiable
        for(int i=0; i< strings.length; i++) {
            list.add(strings[i]);
            map.put(strings[i], i);
        }

        //this.list = Collections.unmodifiableList(this.list);

        //this.map = Collections.unmodifiableMap(this.map);

        System.out.println("===== Printing List =====");
        for(String el: list) {
            System.out.print(el+", ");
        }
        System.out.println("\n");

        System.out.println("===== Printing Map =====");
        for(String el: map.keySet()) {
            System.out.print(el+" => "+map.get(el)+", ");
        }
        System.out.println("\n\n");
    }

    public void readOnly() {
        // writing mistakenly on collections. doesn't have proper permission
        this.list.remove(4);

        this.map.put("Add", 10);

        System.out.println("List contains "+ list.size()+" elements.\n");
        System.out.println("Map contains "+ map.size()+" elements.");
    }
}
