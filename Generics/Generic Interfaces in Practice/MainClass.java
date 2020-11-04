import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        Team<Manager, Specialist> internalTeam = new InternalTeam(new Manager(), new LinkedList<>());
        internalTeam.getMembers();

        InternalTeam internalTeam1 = new InternalTeam(new Manager(), new LinkedList<>());
        internalTeam1.uniqueMethodForInternalTeam();
        internalTeam1.getMembers();

        Team<Manager, Specialist> externalTeam = new ExternalTeam<>(new Manager(), new LinkedList<>());
        externalTeam.getMembers();

        Team<Executive, Operator> externalTeam1 = new ExternalTeam<>(new Executive(), new LinkedList<>());
        externalTeam1.getMembers();

        ExternalTeam<Manager, Specialist, PartTimer> externalTeam2 = new ExternalTeam<>(new Manager(), new LinkedList<>());
        externalTeam2.getMembers();
        externalTeam2.setExternals(new LinkedList<>());

        ExternalTeam<Executive, Operator, Intern> externalTeam3 = new ExternalTeam<>(new Executive(), new LinkedList<>());
        externalTeam3.getMembers();
        externalTeam3.setExternals(new LinkedList<>());

    }
}
