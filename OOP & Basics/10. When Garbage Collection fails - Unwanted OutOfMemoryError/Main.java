import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        while(true) {

            for(int i=0; i< 100; i++) {
                String token = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
                list.add(token + token +token+token+token + token +token+token);
            }

            // do some operation with this 100 element Arraylist. like insert into DB
            // We intend to call clear method. But forgot it...

            list.clear();
        }

    }
}
