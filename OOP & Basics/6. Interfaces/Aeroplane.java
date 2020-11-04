public class Aeroplane implements Flyable, Sellable {


    @Override
    public void fly() {
        System.out.println("Running through runway..");
    }

    @Override
    public String getName() {
        return "Passenger Plane";
    }

    @Override
    public int getPrice() {
        return 2500000;
    }
}
