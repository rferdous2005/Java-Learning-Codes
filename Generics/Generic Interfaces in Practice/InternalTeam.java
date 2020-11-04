import java.util.List;

public class InternalTeam implements Team<Manager, Specialist> {
    Manager leader;
    List<Specialist> members;

    public InternalTeam(Manager leader, List<Specialist> members) {
        this.leader = leader;
        this.members = members;
    }

    @Override
    public Manager getLeader() {
        return leader;
    }

    @Override
    public void setLeader(Manager leader) {
        this.leader = leader;
    }

    @Override
    public List<Specialist> getMembers() {
        return members;
    }

    @Override
    public void setMembers(List<Specialist> members) {
        this.members = members;
    }

    public void uniqueMethodForInternalTeam() {
        System.out.println("Unique method for class");
    }

}
