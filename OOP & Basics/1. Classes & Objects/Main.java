public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle();

        vehicle1.setColor("Red");
        vehicle1.setDoors(4);
        vehicle1.setWheels(4);
        System.out.println(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setColor("Yellow");
        vehicle2.setDoors(2);
        vehicle2.setWheels(8);
        System.out.println(vehicle2);
    }
}
