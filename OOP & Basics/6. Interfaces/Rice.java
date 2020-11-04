public class Rice implements Eatable{
    @Override
    public String getNutrition() {
        return "Carbohydrate";
    }

    @Override
    public int getPrice() {
        return 55;
    }
}
