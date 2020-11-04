import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add(0,"New String");
        System.out.println(strList.get(0).startsWith("New"));

        ArrayList<Car> carList = new ArrayList<>();
        carList.add(0, new Car());
        System.out.println(carList.get(0).getColor());

        ArrayList rawList = new ArrayList();
        rawList.add(0, "New String");
        rawList.add(1, "Another String");

        String s = (String) rawList.get(0);
        System.out.println(s.startsWith("Mew"));

        String s1 = (String) rawList.get(1);
        System.out.println(s1);

    }
}
