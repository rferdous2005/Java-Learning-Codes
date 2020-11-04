public class Vehicle {
    private int doors;
    private int wheels;
    private String color;

    protected String name;

    public Vehicle() {
        System.out.println("Empty Vehicle Constructor");
    }

    public Vehicle(int d, int w, String c) {
        this.doors = d;
        this.wheels = w;
        this.color = c;
    }

    public String toString() {
        String description
                = "This Vehicle has "+ doors+" doors\n"+
                    wheels+ " wheels \n"+"and color is "+ color+"\n";

        return description;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
