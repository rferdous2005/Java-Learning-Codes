import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCards {
    public void genericSubtypes() {
        // String is a subtype of Object, Or String extends Object
        Object obj = "hello";     // A supertype reference holding a subtype instance
        System.out.println(obj);  //hello

        // But ArrayList<String> is not a subtype of ArrayList<Object>
        // ArrayList<Object> lst = new ArrayList<String>(); // Error, not correct

        List<String> strList = new ArrayList<>();
        // List<Object> objList = strList;  // Error, not correct
    }

    public void useWildCards() {
        List<Object> objList = new ArrayList<>();
        objList.add("One");
        objList.add("Two");
        this.printList(objList);

        List<String> stringList = new ArrayList<>();
        stringList.add("One from string list");
        this.printList(stringList);

        List<Integer> intList = Arrays.asList(5,10,15);
        System.out.println(this.sumUsingUpperBound(intList));
        this.printUsingLowerBound(intList);

        List<Double> doubleList = Arrays.asList(5.4,10.49,50.6);
        System.out.println(this.sumUsingUpperBound(doubleList));
        //this.printUsingLowerBound(doubleList); // causes error

        List<Number> numList = Arrays.asList(5,10.49,50.6);
        System.out.println(this.sumUsingUpperBound(numList));
        this.printUsingLowerBound(numList);
    }

    public void printList(List<?> list) {
        for(Object o: list) System.out.println(o);
    }

    public double sumUsingUpperBound(List<? extends Number> numberList) {
        double sum=0;
        for(Number num: numberList) {
            sum += num.doubleValue();
        }
        return  sum;
    }

    public void printUsingLowerBound(List<? super Integer> list) {
        System.out.println(list);
    }
}
