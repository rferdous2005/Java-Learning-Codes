public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle(4, 4, "Red");

        System.out.println(vehicle1);

        Car vehicle2 = new Toyota();
        vehicle2.setWheels(4);
        vehicle2.setDoors(2);
        vehicle2.setColor("White");
        System.out.println(vehicle2);


        Vehicle carVehicle = new Car(2,4,"White", "Luxury", "Power Car");
        carVehicle.setWheels(4);
        carVehicle.setDoors(2);
        carVehicle.setColor("White");
        carVehicle.name = "Power Car";
        System.out.println(carVehicle);

        Car car = new Car(4, 8,"White", "Economy", "Beast");
        car.setColor("Blue");
        car.setModel("M-001");
        car.setType("CAR");
        car.setName("Power Beast");
        System.out.println(car);

    }
}
