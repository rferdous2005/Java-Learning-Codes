public class Chicken implements Flyable, Eatable {
    @Override
    public String getNutrition() {
        return "Protein";
    }

    @Override
    public void fly() {
        System.out.println("Flying rarely. Only when necessary");
    }

    @Override
    public String getName() {
        return "Desi Chicken";
    }

    @Override
    public int getPrice() {
        return 250;
    }
}
