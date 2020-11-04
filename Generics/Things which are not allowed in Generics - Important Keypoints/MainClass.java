import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // List is generic type
        List<String> stringList = new LinkedList<>(); // parameterized type

        List<Integer> intList = new LinkedList<>(); // parameterized type

        List list = new LinkedList(); // raw type

        // primitive types are not allowed as generic actual type arguments/parameters
        List<int> primitiveList = new LinkedList<>();

        // Formal type parameter VS Actual type parameter
        Team<String, Integer> team = new Team<>();

        // problem with subtypes in Generic Actual Type Params
        Number num = Long.valueOf("123");
        List<Number> someNumbers = new ArrayList<Long>();
        List<Number> numbers = new ArrayList<Number>();

        // Cannot use wildcards while instantiating, Right side of the assignment
        List<?> l = new ArrayList<?>();

    }

    // Cannot use wildcards as Generic Method Formal Type parameter
    public <? extends Animal> void takeThing(ArrayList<?> list) {

    }

}
