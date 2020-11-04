public class Main {
    public static void main(String[] args) {

        MyClass myClass1 = new MyClass();

        MyClass.number +=10;

        //MyClass myClass2 = new MyClass();

        MyClass.number += 10;

        System.out.println(MyClass.number);

        System.out.println(MyClass.number);
        System.out.println();

        myClass1.normalMethod();
        MyClass.staticMethod();

        System.out.println(MyClass.number);

    }
}
