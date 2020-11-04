
public class Main {
    public static void main(String[] args) {

        char charVariable = 'A';

        Character anotherCharVariable = 'h';

        charVariable = anotherCharVariable;

        anotherCharVariable = charVariable;


        int intVariable = 50;
        Integer anotherIntVariable = intVariable;

        Double doubleVariable = 40.9;

        double anotherDoubleVariable = doubleVariable;

        System.out.println(charVariable);
        System.out.println(anotherCharVariable);

        System.out.println(intVariable);
        System.out.println(anotherIntVariable);

        System.out.println(doubleVariable);
        System.out.println(anotherDoubleVariable);
    }
}
