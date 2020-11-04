public class Eagle implements Flyable, Lively{

    @Override
    public void fly() {
        System.out.println("Flapping feathers.. Flying.");
    }

    @Override
    public String getName() {
        return "White Eagle";
    }

    @Override
    public int getLivingYears() {
        return 80*365;
    }
}
