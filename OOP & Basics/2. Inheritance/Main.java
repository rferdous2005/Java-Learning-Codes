public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setColor("Red");
        vehicle.setDoors(4);
        vehicle.setWheels(4);
        System.out.println(vehicle);

        Vehicle carVehicle = new Car();
        carVehicle.setWheels(4);
        carVehicle.setDoors(2);
        carVehicle.setColor("White");
        carVehicle.name = "Power Car";
        System.out.println(carVehicle);

        Car car = new Car();
        car.setColor("Blue");
        car.setModel("M-001");
        car.setType("CAR");
        car.setName("Power Beast");
        System.out.println(car);

        Toyota toyota = new Toyota();
        toyota.model = "TY-004";
        toyota.type = "Luxury";
        System.out.println(toyota);

    }
}
