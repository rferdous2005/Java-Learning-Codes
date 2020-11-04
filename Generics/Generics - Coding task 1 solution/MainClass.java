
public class MainClass {
    public static void main(String[] args) {
        MyList myList = new MyList();
        MyString myString = new MyString();

        myString.append(new MyList())
                .append(new MyString())
                .append(new MyString());

        myList.append(new MyList())
                .append(new MyList())
                .append(new MyString());

    }
}
