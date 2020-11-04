import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Eagle eagle = new Eagle();

        Aeroplane aeroplane = new Aeroplane();

        Chicken chicken = new Chicken();

        Rice rice = new Rice();

        sell(aeroplane);

        eat(chicken);

        eat(rice);
    }

    public static void sell(Sellable sellable) {
        sellable.getPrice();
    }

    public static void eat(Eatable eatable) {
        System.out.println(eatable.getNutrition());
        System.out.println(eatable.getPrice());
    }
}
