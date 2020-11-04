import java.util.List;

public class Team<L extends Employee & TeamLeader, M extends Employee> {
    L leader;
    List<M> members;

    public Team(L leader, List<M> members) {
        this.leader = leader;
        this.members = members;
    }

    public L getLeader() {
        return leader;
    }

    public void setLeader(L leader) {
        this.leader = leader;
    }

    public List<M> getMembers() {
        return members;
    }

    public void setMembers(List<M> members) {
        this.members = members;
    }
}
