import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        Team<Manager, Specialist> team = new Team<>(new Manager(), new LinkedList<Specialist>());

        Team<Executive, Operator> anotherTeam = new Team<>(new Executive(), new LinkedList<Operator>());
    }
}
