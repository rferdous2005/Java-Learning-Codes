
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // Working with Generic Methods
        GenericMethodExample genericMethod = new GenericMethodExample();

        String stringElement = "stringElement";
        List<String> stringList = new ArrayList<String>();
        genericMethod.<String>addElementToList(stringElement, stringList);
        System.out.println(stringList);

        Object objElement = new Object();
        // following line of code will generate compile error. Find out why..
        // genericMethod.addElementToList(objElement, stringList);

        List<Object> objectList = new ArrayList<>();
        genericMethod.addElementToList(stringElement, objectList);
        System.out.println(objectList);

        Integer integerElement = 123;
        List<Integer> integerList = new ArrayList<>();
        genericMethod.addElementToList(integerElement, integerList);
        genericMethod.addElementToList(5000, integerList);
        System.out.println(integerList);

        GenericMethodExample genericMethodExample = new GenericMethodExample();
        List<GenericMethodExample> genericMethodExampleList = new ArrayList<>();
        genericMethod.<GenericMethodExample>addElementToList(genericMethodExample, genericMethodExampleList);
        System.out.println(genericMethodExampleList);

        // working with wild cards
        WildCards wildCards = new WildCards();
        wildCards.genericSubtypes();
        wildCards.useWildCards();

    }


}
